package com.wefin.gerenciapessoa.domain.enums;

public enum TipoIdentificadorEnum {

	CPF(1),
	CNPJ(2);
	
	private int codigo;
	
	TipoIdentificadorEnum(int codigo) {
		this.codigo = codigo;
	}
	
	public int getCodigo() {
		return this.codigo;
	}
}