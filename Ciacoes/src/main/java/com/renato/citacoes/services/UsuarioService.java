package com.renato.citacoes.services;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.renato.citacoes.domain.Usuario;
import com.renato.citacoes.dto.UsuarioDTO;
import com.renato.citacoes.repositories.UsuarioRepository;
import com.renato.citacoes.services.exceptions.ObjectNotFoundException;

@Service
public class UsuarioService {

	@Autowired
	UsuarioRepository usuarioRepository;
	
	public Usuario findById(Integer id) {
		Optional<Usuario> obj = usuarioRepository.findById(id);
		return obj.orElseThrow(()-> new ObjectNotFoundException("Objeto não encontrado!"
				+ "Id: "+id+", Tipo: "+Usuario.class.getName()));
	}
	
	public Usuario insert(Usuario obj) {
		obj.setId(null);
		return usuarioRepository.save(obj);
	}
	
	public Usuario fromDto(UsuarioDTO usuarioDto) {
		return new Usuario(usuarioDto.getId(), usuarioDto.getEmail(), usuarioDto.getNome());
	}
}	
