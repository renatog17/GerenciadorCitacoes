package com.renato.citacoes.dto;

import java.io.Serializable;

import com.renato.citacoes.domain.Citacao;

public class CitacaoDTO implements Serializable{
	private static final long serialVersionUID = 1L;
	
	private Integer id;
	private String conteudo;
	private String isbn;
	
	public CitacaoDTO(Citacao citacao) {
		super();
		this.id = citacao.getId();
		this.conteudo = citacao.getConteudo();
		this.isbn = citacao.getIsbn();
	}
	
	public CitacaoDTO() {
		super();
	}
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getConteudo() {
		return conteudo;
	}
	public void setConteudo(String conteudo) {
		this.conteudo = conteudo;
	}
	public String getIsbn() {
		return isbn;
	}
	public void setIsbn(String isbn) {
		this.isbn = isbn;
	}
}
