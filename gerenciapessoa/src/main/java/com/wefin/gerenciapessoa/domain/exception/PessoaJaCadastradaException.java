package com.wefin.gerenciapessoa.domain.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.UNPROCESSABLE_ENTITY)
public class PessoaJaCadastradaException extends RuntimeException {

	private static final long serialVersionUID = -8746605561124150916L;
	
	public PessoaJaCadastradaException(String message) {
		super(message);
	}
}
