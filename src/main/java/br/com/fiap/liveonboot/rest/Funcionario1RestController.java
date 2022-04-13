package br.com.fiap.liveonboot.rest;

import java.net.URI;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import br.com.fiap.liveonboot.domain.Funcionario1;
import br.com.fiap.liveonboot.repository.Funcionario1Repository;

@RestController
@RequestMapping("/funcionario1")
@CrossOrigin("*")
public class Funcionario1RestController {

	@Autowired
	Funcionario1Repository repository;

	@GetMapping
	public ResponseEntity<List<Funcionario1>> findAll() {
		List<Funcionario1> lista = repository.findAll();
		return ResponseEntity.ok(lista);
	}

	@SuppressWarnings("rawtypes")
	@PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE)
	@CrossOrigin("*")
	public ResponseEntity post(@RequestBody Funcionario1 funcionario) {

		repository.save(funcionario);

		URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}")
				.buildAndExpand(funcionario.getId()).toUri();

		return ResponseEntity.created(location).build();

	}

}
