package com.renato.citacoes.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort.Direction;
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
	
	public List<Citacao> findAll(){
		return citacaoRepository.findAll();
	}
	
	public Page<Citacao> findPage(Integer page, Integer linesPerPage,
			String orderBy, String direction) {
		PageRequest pageRequest = PageRequest
				.of(page, linesPerPage, Direction.valueOf(direction), orderBy);
		return citacaoRepository.findAll(pageRequest);
	}
}
