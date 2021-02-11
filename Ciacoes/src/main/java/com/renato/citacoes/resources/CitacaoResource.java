package com.renato.citacoes.resources;

import java.net.URI;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.renato.citacoes.domain.Citacao;
import com.renato.citacoes.services.CitacaoService;

@RestController
@RequestMapping(value = "/citacoes")
public class CitacaoResource {

	@Autowired
	CitacaoService citacaoService;
	
	@RequestMapping(value = "/{id}", method = RequestMethod.GET)
	public ResponseEntity<Citacao> find(@PathVariable Integer id){
		Citacao citacao = citacaoService.findById(id);
		return ResponseEntity.ok().body(citacao);
	}
	
	@RequestMapping(method = RequestMethod.POST)
	public ResponseEntity<Void> insert(@RequestBody Citacao obj){
		obj = citacaoService.insert(obj);
		URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}")
				.buildAndExpand(obj.getId()).toUri();
		return ResponseEntity.created(uri).build();
	}
	
	@RequestMapping(value = "/{id}", method = RequestMethod.PUT)
	public ResponseEntity<Void> update(@RequestBody Citacao obj, @PathVariable Integer id){
		obj.setId(id);
		obj = citacaoService.update(obj);
		return ResponseEntity.noContent().build();
	}
	
	@RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
	public ResponseEntity<Void> delete(@PathVariable Integer id){
		citacaoService.delete(id);
		return ResponseEntity.noContent().build();
	}
	
}
