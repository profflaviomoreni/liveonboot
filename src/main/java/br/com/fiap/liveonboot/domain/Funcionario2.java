package br.com.fiap.liveonboot.domain;

import java.util.UUID;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "FUNC2")
public class Funcionario2 {
	
	
	@Id
	//@GeneratedValue(generator = "uuid2")
    @Column(name = "ID", nullable = false)
	private UUID id;

    @Column(name = "NAME", length = 50, nullable = false)
    private String name;

	public UUID getId() {
		return id;
	}

	public void setId(UUID id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

    
    
    
}
