package com.wefin.gerenciapessoa.domain.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.wefin.gerenciapessoa.api.assembler.PessoaInputModelDisAssembler;
import com.wefin.gerenciapessoa.api.model.input.PessoaInputModel;
import com.wefin.gerenciapessoa.domain.entity.Pessoa;
import com.wefin.gerenciapessoa.domain.exception.IdentificadorNaoInformadoException;
import com.wefin.gerenciapessoa.domain.exception.IdentificadorNaoNumericoException;
import com.wefin.gerenciapessoa.domain.exception.PessoaJaCadastradaException;
import com.wefin.gerenciapessoa.domain.repository.PessoaRepository;

@Service
public class CadastroPessoaService {

	@Autowired
	PessoaRepository pessoaRepository;
	
	@Autowired
	PessoaInputModelDisAssembler disassembler;
	
	public Pessoa adicionar(PessoaInputModel model) {
		validaIdentificador(model.getIdentificador());
		return pessoaRepository.save(disassembler.toDomainObject(model));
	}
	
	public void existeIdentificador(String identificador) {
		if(identificador == null || identificador.isEmpty()) {
			throw new IdentificadorNaoInformadoException("Deve ser informado o identificador.");
		}
		
		Optional<Pessoa> entity = pessoaRepository.findById(identificador);
		
		if(entity.isPresent()) {
			throw new PessoaJaCadastradaException(String.format("Identificador %s já cadastrado.", identificador));
		}
	}
	
	private void validaIdentificador(String identificador) {
		if(!identificador.matches("[0-9]*")) {
			throw new IdentificadorNaoNumericoException("O Identificador deve possuir apenas caracteres númericos.");
		}
			
	}
}
