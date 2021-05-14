package com.lucinda.models;

import java.time.LocalDate;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;


@Entity
public class Pasta {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	private String nome;
	private LocalDate dataModificacao;
	@OneToMany(mappedBy = "pasta")
	private List<Part> partes;
	
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public LocalDate getDataModificacao() {
		return dataModificacao;
	}
	public void setDataModificacao(LocalDate dataModificacao) {
		this.dataModificacao = dataModificacao;
	}
	public List<Part> getPartes() {
		return partes;
	}
	public void setPartes(List<Part> partes) {
		this.partes = partes;
	}
	
	
	
}

