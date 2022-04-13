package br.com.fiap.liveonboot.rest;

import java.net.URI;
import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import br.com.fiap.liveonboot.domain.Funcionario2;
import br.com.fiap.liveonboot.repository.Funcionario2Repository;

@RestController
@RequestMapping("/funcionario2")
@CrossOrigin("*")
public class Funcionario2RestController {

	@Autowired
	Funcionario2Repository repository;

	@GetMapping
	public ResponseEntity<List<Funcionario2>> findAll() {
		List<Funcionario2> lista = repository.findAll();
		return ResponseEntity.ok(lista);
	}
	
	
	@GetMapping("/{id}")
	public ResponseEntity<Funcionario2> findById(@PathVariable("id") UUID id ) {
		return ResponseEntity.ok( repository.findById(id).get() );
	}
	
	

	@SuppressWarnings("rawtypes")
	@PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE)
	@CrossOrigin("*")
	public ResponseEntity post(@RequestBody Funcionario2 funcionario) {
		funcionario.setId(UUID.randomUUID());
		repository.save(funcionario);

		URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}")
				.buildAndExpand(funcionario.getId()).toUri();

		return ResponseEntity.created(location).build();

	}
	
	
}
