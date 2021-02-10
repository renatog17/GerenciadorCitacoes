package com.renato.citacoes.services;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.renato.citacoes.domain.Usuario;
import com.renato.citacoes.repositories.UsuarioRepository;
import com.renato.citacoes.services.exceptions.ObjectNotFoundException;

@Service
public class UsuarioService {
	
	@Autowired
	private UsuarioRepository usuarioRepository;
	
	public Usuario findById(Integer id) {
		Optional<Usuario> usuario = usuarioRepository.findById(id);
		return usuario.orElseThrow(()-> new ObjectNotFoundException("Objeto não encontrado!"
				+ "Id: "+id+", Tipo: "+Usuario.class.getName()));
	}
	
}
