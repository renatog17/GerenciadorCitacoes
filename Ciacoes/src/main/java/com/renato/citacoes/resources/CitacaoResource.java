package com.renato.citacoes.resources;

import java.net.URI;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.renato.citacoes.domain.Citacao;
import com.renato.citacoes.dto.CitacaoDTO;
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
	
	@RequestMapping(method = RequestMethod.GET)
	public ResponseEntity<List<CitacaoDTO>> findAll(){
		List<Citacao> list = citacaoService.findAll();
		List<CitacaoDTO> listDto = list.stream().map(obj -> new CitacaoDTO(obj)).collect(Collectors.toList());
		return ResponseEntity.ok().body(listDto);
	}
	
	@RequestMapping(value = "/page", method = RequestMethod.GET)
	public ResponseEntity<Page<CitacaoDTO>> findAll(
			@RequestParam(value="page", defaultValue = "0") Integer page, 
			@RequestParam(value="linesPerPage", defaultValue = "24") Integer linesPerPage,
			@RequestParam(value="orderBy", defaultValue = "id") String orderBy, 
			@RequestParam(value="direction", defaultValue = "ASC") String direction){
		Page<Citacao> list = citacaoService.findPage(page, linesPerPage, orderBy, direction);
		Page<CitacaoDTO> listDto = list.map(obj -> new CitacaoDTO(obj));
		return ResponseEntity.ok().body(listDto);
	}
}
