package com.wefin.gerenciapessoa.api.controller;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.wefin.gerenciapessoa.api.assembler.PessoaInputModelDisAssembler;
import com.wefin.gerenciapessoa.api.assembler.PessoaModelAssembler;
import com.wefin.gerenciapessoa.api.model.PessoaModel;
import com.wefin.gerenciapessoa.api.model.input.PessoaInputModel;
import com.wefin.gerenciapessoa.api.openapi.controller.PessoaControllerOpenApi;
import com.wefin.gerenciapessoa.domain.service.CadastroPessoaService;

import io.swagger.v3.oas.annotations.tags.Tag;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;

@RestController
@RequestMapping(value="/pessoas")
@Tag(name = "Pessoas", description = "Gerencia cadastro de pessoas")
public class PessoaController implements PessoaControllerOpenApi {
	
	@Autowired
	CadastroPessoaService cadastroPessoa;
	
	@Autowired
	PessoaModelAssembler assembler;
	
	@Autowired
	PessoaInputModelDisAssembler disassembler;

	@Override
	@PostMapping
	@ResponseStatus(HttpStatus.CREATED)
	public PessoaModel adicionar(@RequestBody @Valid PessoaInputModel pessoa) {
		cadastroPessoa.existeIdentificador(pessoa.getIdentificador());

		return assembler.toModel(cadastroPessoa.adicionar(pessoa));
	}
}