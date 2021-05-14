package com.lucinda.models;

import java.time.LocalDate;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

@Entity
public class Modificacao {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	@ManyToOne
	private Part parte;
	private LocalDate data;
	private Integer revisao;
	private boolean primeiraRev;
	private boolean contabilizar;
	private String modificacoes;
	
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public Part getParte() {
		return parte;
	}
	public void setParte(Part parte) {
		this.parte = parte;
	}
	public LocalDate getData() {
		return data;
	}
	public void setData(LocalDate data) {
		this.data = data;
	}
	public boolean isPrimeiraRev() {
		return primeiraRev;
	}
	public void setPrimeiraRev(boolean primeiraRev) {
		this.primeiraRev = primeiraRev;
	}
	public boolean isContabilizar() {
		return contabilizar;
	}
	public void setContabilizar(boolean contabilizar) {
		this.contabilizar = contabilizar;
	}
	public String getModificacoes() {
		return modificacoes;
	}
	public void setModificacoes(String modificacoes) {
		this.modificacoes = modificacoes;
	}
	public Integer getRevisao() {
		return revisao;
	}
	public void setRevisao(Integer revisao) {
		this.revisao = revisao;
	}
	
	
}
