package com.renato.citacoes.services;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Service;

import com.renato.citacoes.domain.Citacao;
import com.renato.citacoes.repositories.CitacaoRepository;
import com.renato.citacoes.services.exceptions.DataIntegrityException;
import com.renato.citacoes.services.exceptions.ObjectNotFoundException;

@Service
public class CitacaoService {
	
	@Autowired
	private CitacaoRepository citacaoRepository;
	
	public Citacao findById(Integer id) {
		Optional<Citacao> citacao = citacaoRepository.findById(id);
		return citacao.orElseThrow(()-> new ObjectNotFoundException("Objeto não encontrado!"
				+ "Id: "+id+", Tipo: "+Citacao.class.getName()));
	}
	
	public Citacao insert(Citacao obj) {
		obj.setId(null);
		return citacaoRepository.save(obj);
	}
	
	public Citacao update(Citacao obj) {
		findById(obj.getId());
		return citacaoRepository.save(obj);
	}
	
	public void delete(Integer id) {
		findById(id);
		try {
			citacaoRepository.deleteById(id);
		}catch (DataIntegrityViolationException e) {
			throw new DataIntegrityException("Não é possível deletar uma citação com comentários!");
		}
	}
}
