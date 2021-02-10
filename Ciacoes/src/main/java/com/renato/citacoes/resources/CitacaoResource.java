package com.renato.citacoes.resources;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.renato.citacoes.domain.Citacao;
import com.renato.citacoes.services.CitacaoService;

@RestController
@RequestMapping(value = "/citacoes")
public class CitacaoResource {

	@Autowired
	CitacaoService citacaoService;
	
	@RequestMapping(value = "/{id}", method = RequestMethod.GET)
	public ResponseEntity<?> find(@PathVariable Integer id){
		Citacao citacao = citacaoService.findById(id);
		return ResponseEntity.ok().body(citacao);
	}
}
