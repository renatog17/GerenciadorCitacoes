package com.renato.citacoes.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.renato.citacoes.domain.Comentario;

public interface ComentarioRepository extends JpaRepository<Comentario, Integer>{

}
