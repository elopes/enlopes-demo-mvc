package com.enlopes.curso.boot.domain;

import java.util.List;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

@SuppressWarnings("serial")
@Entity
@Table(name="DEPARTAMENTOS") // Nome da tabela no BD
public class Departamento extends AbstractEntity<Long>{
	
	@NotBlank(message = "Informe um nome.")
	@Size(min = 3, max = 60, message = "O nome do departamento deve ter entre {min} e {max} caracteres.")
	@Column(name="nome", nullable = false, unique = true,  length = 60 ) // Coluna nome , não nula, única e com no máximo 60 caracteres.
	private String nome;
	
	// Atributo tipo List para cargos
	@OneToMany(mappedBy="departamento") // Temos vários cargos para um departamento
	private List<Cargo> cargos;
	
	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public List<Cargo> getCargos() {
		return cargos;
	}

	public void setCargos(List<Cargo> cargos) {
		this.cargos = cargos;
	}
	
	
}
