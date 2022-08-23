package com.wefin.gerenciapessoa.api.assembler;

import java.io.Serializable;

import org.springframework.stereotype.Component;

import com.wefin.gerenciapessoa.api.model.input.PessoaInputModel;
import com.wefin.gerenciapessoa.domain.entity.Pessoa;
import com.wefin.gerenciapessoa.domain.entity.TipoIdentificador;
import com.wefin.gerenciapessoa.domain.enums.TipoIdentificadorEnum;
import com.wefin.gerenciapessoa.domain.exception.TamanhoIdentificadorException;

@Component
public class PessoaInputModelDisAssembler implements Serializable {

	private static final long serialVersionUID = -4468223610702905443L;

	public Pessoa toDomainObject(PessoaInputModel model) {
		Pessoa entity= new Pessoa();
		
		entity.setIdentificador(model.getIdentificador());
		entity.setNome(model.getNome());
		entity.setTipoIdentificador(getTipoIdentificador(model.getIdentificador()));
		
		return entity;
	}
	
	private TipoIdentificador getTipoIdentificador(String identificador) {
		TipoIdentificador tipo = new TipoIdentificador();
		
		if(identificador.length() == 11) {
			tipo.setId(TipoIdentificadorEnum.CPF.getCodigo());
		} else if(identificador.length() == 14) {
			tipo.setId(TipoIdentificadorEnum.CNPJ.getCodigo());
		} else {
			throw new TamanhoIdentificadorException("O campo identificador deve possuir 11 caracteres para CPF ou 14 caracteres para CNPJ");
		}
		
		return tipo;
	}
}