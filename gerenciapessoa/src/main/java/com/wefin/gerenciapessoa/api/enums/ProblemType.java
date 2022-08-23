package com.wefin.gerenciapessoa.api.enums;

import lombok.Getter;

@Getter
public enum ProblemType {

	MENSAGEM_INCOMPREENSIVEL("Mensagem incompreensível."),
	ENTIDADE_JA_CADASTRADA("Entidade já cadastrada."),
	ERRO_IDENTIFICADOR("Campo identificador está fora do padrão especificado.");
	
	private String title;
	
	ProblemType(String title) {
		this.title = title;
	}
}