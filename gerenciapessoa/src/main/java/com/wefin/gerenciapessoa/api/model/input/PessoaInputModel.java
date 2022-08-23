package com.wefin.gerenciapessoa.api.model.input;

import java.io.Serializable;

import javax.validation.constraints.NotBlank;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class PessoaInputModel implements Serializable {

	private static final long serialVersionUID = 859973114188113303L;

	@NotBlank
	@Schema(required = true)
	private String nome;

	@Schema(required = true)
	private String identificador;
}
