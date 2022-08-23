package com.wefin.gerenciapessoa.domain.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.UNSUPPORTED_MEDIA_TYPE)
public class TamanhoIdentificadorException extends RuntimeException {

	private static final long serialVersionUID = -8746605561124150916L;
	
	public TamanhoIdentificadorException(String message) {
		super(message);
	}
}
