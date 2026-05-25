package com.livrotech.entity;

import java.util.List;

import jakarta.persistence.Column;
import jakarta.persistence.ElementCollection;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "Cliente")
public class Customer extends Person {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@Column(nullable = false)
	private String status;
	
	@ElementCollection
	private List<Sale> compras;

	public Customer(String nome, String cpf, Long id, String status, List<Sale> compras) {
		super(nome, cpf);
		this.id = id;
		this.status = status;
		this.compras = compras;
	}

	public Customer(String nome, String cpf) {
		super(nome, cpf);
	}

	public Customer() {
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public Long getId() {
		return id;
	}

	public List<Sale> getCompras() {
		return compras;
	}

	public void setCompras(List<Sale> compras) {
		this.compras = compras;
	}
	

}
