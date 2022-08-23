package com.wefin.gerenciapessoa.domain.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import lombok.Data;

@Data
@Entity
public class Pessoa implements Serializable {
	
	private static final long serialVersionUID = 8552189395016094083L;
	
	@Id
	@Column(name = "identificador", length = 14, nullable = false)
	private String identificador;
	
	@Column(name = "nome", nullable = false)
	private String nome;
	
	@ManyToOne
	@JoinColumn(name = "id_tipo_Identificador", nullable = false)
	private TipoIdentificador tipoIdentificador;

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}
		if (obj == null) {
			return false;
		}
		if (getClass() != obj.getClass()) {
			return false;
		}
		Pessoa other = (Pessoa) obj;
		if (identificador == null) {
			if (other.identificador != null) {
				return false;
			}
		} else if (!identificador.equals(other.identificador)) {
			return false;
		}
		return true;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((identificador == null) ? 0 : identificador.hashCode());
		return result;
	}
}