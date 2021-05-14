package com.lucinda.models;

import java.time.LocalDate;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

@Entity
public class Part {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	private String nome;
	private Integer revisao;
	private LocalDate data;
	@ManyToOne
	private Pasta pasta;
	@OneToMany(mappedBy = "parte")
	private List<Modificacao> modificacao;
	
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
	public Integer getRevisao() {
		return revisao;
	}
	public void setRevisao(Integer revisao) {
		this.revisao = revisao;
	}
	public LocalDate getData() {
		return data;
	}
	public void setData(LocalDate data) {
		this.data = data;
	}
	public Pasta getPasta() {
		return pasta;
	}
	public void setPasta(Pasta pasta) {
		this.pasta = pasta;
	}
	public List<Modificacao> getModificacao() {
		return modificacao;
	}
	public void setModificacao(List<Modificacao> modificacao) {
		this.modificacao = modificacao;
	}
	
	
	


	
	
	
}
