package com.renato.citacoes.domain;

import java.io.Serializable;

public class Comentario implements Serializable{
	private static final long serialVersionUID = 1L;

	private Integer id;
	private String conteudo;
	private Usuario autor;
	private Citacao citacao;
	
	public Comentario() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Comentario(Integer id, String conteudo, Usuario autor, Citacao citacao) {
		super();
		this.id = id;
		this.conteudo = conteudo;
		this.autor = autor;
		this.citacao = citacao;
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
	public Usuario getAutor() {
		return autor;
	}
	public void setAutor(Usuario autor) {
		this.autor = autor;
	}
	public Citacao getCitacao() {
		return citacao;
	}
	public void setCitacao(Citacao citacao) {
		this.citacao = citacao;
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		return result;
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Comentario other = (Comentario) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}
}
