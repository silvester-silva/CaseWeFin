package com.wefin.gerenciapessoa.api.assembler;

import java.io.Serializable;

import org.springframework.stereotype.Component;

import com.wefin.gerenciapessoa.api.model.PessoaModel;
import com.wefin.gerenciapessoa.domain.entity.Pessoa;

@Component
public class PessoaModelAssembler implements Serializable {

	private static final long serialVersionUID = -2999189412887705741L;

	public PessoaModel toModel(Pessoa pessoa) {
		PessoaModel model = new PessoaModel();

		model.setIdentificador(pessoa.getIdentificador());
		model.setNome(pessoa.getNome());
		model.setTipoIdentificador(pessoa.getTipoIdentificador().getDescricao());
		
		return model;
	}
}