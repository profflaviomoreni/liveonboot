package br.com.fiap.liveonboot.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.fiap.liveonboot.domain.Funcionario1;

@Repository
public interface Funcionario1Repository extends JpaRepository<Funcionario1, Long> {

	
	
}
