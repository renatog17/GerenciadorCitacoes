package com.renato.citacoes.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.renato.citacoes.domain.Citacao;

public interface CitacaoRepository extends JpaRepository<Citacao, Integer>{

}
