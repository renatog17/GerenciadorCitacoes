package com.renato.citacoes.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.renato.citacoes.domain.Usuario;

public interface UsuarioRepository extends JpaRepository<Usuario, Integer>{

}
