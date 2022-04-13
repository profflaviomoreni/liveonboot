package br.com.fiap.liveonboot.repository;

import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.fiap.liveonboot.domain.Funcionario2;

@Repository
public interface Funcionario2Repository extends JpaRepository<Funcionario2, UUID> {

}
