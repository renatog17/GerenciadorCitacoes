package com.renato.citacoes.dto;

import java.io.Serializable;

import javax.validation.constraints.NotEmpty;

import org.hibernate.validator.constraints.Length;

import com.renato.citacoes.domain.Usuario;

public class UsuarioDTO implements Serializable{
	private static final long serialVersionUID = 1L;
	
	private Integer id;
	@NotEmpty(message = "O campo não pode ser nulo")
	@Length(min = 20, message = "Tamanho mínimo: 20 caracteres")
	private String nome;
	private String email;
	
	public UsuarioDTO() {
		super();
	}

	public UsuarioDTO(Usuario usuario) {
		super();
		this.id = usuario.getId();
		this.nome = usuario.getNome();
		this.email = usuario.getEmail();
	}

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

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}
}
