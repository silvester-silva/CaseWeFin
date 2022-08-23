package com.wefin.gerenciapessoa.api.model;

import java.io.Serializable;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class PessoaModel implements Serializable{

	private static final long serialVersionUID = -8035597932826547494L;
	
	private String nome;
	private String identificador;
	private String tipoIdentificador;
}