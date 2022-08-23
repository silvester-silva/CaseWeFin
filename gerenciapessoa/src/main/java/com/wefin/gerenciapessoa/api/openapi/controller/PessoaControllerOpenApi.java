package com.wefin.gerenciapessoa.api.openapi.controller;

import com.wefin.gerenciapessoa.api.model.PessoaModel;
import com.wefin.gerenciapessoa.api.model.input.PessoaInputModel;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.parameters.RequestBody;
import io.swagger.v3.oas.annotations.tags.Tag;

@Tag(name = "Pessoas")
public interface PessoaControllerOpenApi {

	@Operation(summary = "Cadastra uma pessoa", description = "Cadastro de uma pessoa, necessita de um identificador(CPF ou CNPJ) e um nome")
	PessoaModel adicionar(@RequestBody(description = "Representação de uma nova pessoa", required = true) PessoaInputModel pessoa);
}
