package com.wefin.gerenciapessoa.api.exceptionhandler;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import com.wefin.gerenciapessoa.api.enums.ProblemType;
import com.wefin.gerenciapessoa.domain.exception.IdentificadorNaoInformadoException;
import com.wefin.gerenciapessoa.domain.exception.IdentificadorNaoNumericoException;
import com.wefin.gerenciapessoa.domain.exception.PessoaJaCadastradaException;
import com.wefin.gerenciapessoa.domain.exception.TamanhoIdentificadorException;

@ControllerAdvice
public class ApiExceptionHandler extends ResponseEntityExceptionHandler {

	@Override
	protected ResponseEntity<Object> handleHttpMessageNotReadable(HttpMessageNotReadableException ex, HttpHeaders headers, HttpStatus status, WebRequest request) {	
		Problem problem = createProblemBuilder(status, ProblemType.MENSAGEM_INCOMPREENSIVEL, "O corpo da requisição está inválido. Verifique erro de sintaxe.").build();

		return handleExceptionInternal(ex, problem, headers, status, request);
	}

	@ExceptionHandler(PessoaJaCadastradaException.class)
	public ResponseEntity<?> handleEntidadeNaoEncontradaException(PessoaJaCadastradaException ex, WebRequest request) {
		HttpStatus status = HttpStatus.UNPROCESSABLE_ENTITY;
		
		Problem problem = createProblemBuilder(status, ProblemType.ERRO_IDENTIFICADOR, ex.getMessage()).build();
		
		return handleExceptionInternal(ex, problem, new HttpHeaders(), status, request);
	}
	
	@ExceptionHandler({ TamanhoIdentificadorException.class,IdentificadorNaoNumericoException.class, IdentificadorNaoInformadoException.class })
	public ResponseEntity<?> handleTamanhoIdentificadorException(Exception ex, WebRequest request) {
		HttpStatus status = HttpStatus.UNSUPPORTED_MEDIA_TYPE;
		
		Problem problem = createProblemBuilder(status, ProblemType.ERRO_IDENTIFICADOR, ex.getMessage()).build();
		
		return handleExceptionInternal(ex, problem, new HttpHeaders(), status, request);
	}
	
	@Override
	protected ResponseEntity<Object> handleExceptionInternal(Exception ex, Object body, HttpHeaders headers, HttpStatus status, WebRequest request) {
		if (body == null) {
			body = Problem.builder()
				.title(status.getReasonPhrase())
				.status(status.value())
				.build();
		} else if (body instanceof String) {
			body = Problem.builder()
				.title((String) body)
				.status(status.value())
				.build();
		}
		return super.handleExceptionInternal(ex, body, headers, status, request);
	}
	
	private Problem.ProblemBuilder createProblemBuilder(HttpStatus status, ProblemType problemType, String detail) {
		return Problem.builder()
			.status(status.value())
			.title(problemType.getTitle())
			.detail(detail);
	}
}