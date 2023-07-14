package com.br.contabilidade.coutinho.gerenciador.cliente;


import java.time.LocalDate;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "clientes")
public class Cliente {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	@Column(name = "razao_social")
	private String razaoSocial;
	private String cnpj;
	@Column(name = "ultimo_mes_feito")
	private LocalDate ultimoMesFeito;
	private Situacao situacao;
	
	public Cliente() {}
	
	public Cliente(long id, String razaoSocial, String cnpj, LocalDate ultimoMesFeito, Situacao situacao) {
		this.id = id;
		this.razaoSocial = razaoSocial;
		this.cnpj = cnpj;
		this.ultimoMesFeito = ultimoMesFeito;
		this.situacao = situacao;
	}
	
	
	public Cliente(String razaoSocial, String cnpj, LocalDate ultimoMesFeito, Situacao situacao) {
		this.razaoSocial = razaoSocial;
		this.cnpj = cnpj;
		this.ultimoMesFeito = ultimoMesFeito;
		this.situacao = situacao;
	}

	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public String getRazaoSocial() {
		return razaoSocial;
	}
	public void setRazaoSocial(String razaoSocial) {
		this.razaoSocial = razaoSocial;
	}
	public String getCnpj() {
		return cnpj;
	}
	public void setCnpj(String cnpj) {
		this.cnpj = cnpj;
	}
	public LocalDate getUltimoMesFeito() {
		return ultimoMesFeito;
	}
	public void setUltimoMesFeito(LocalDate ultimoMesFeito) {
		this.ultimoMesFeito = ultimoMesFeito;
	}
	public Situacao getSituacao() {
		return situacao;
	}
	public void setSituacao(Situacao situacao) {
		this.situacao = situacao;
	}
	
	
}
