package com.livrotech.service;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.livrotech.entity.Customer;
import com.livrotech.exception.GlobalExceptionHandler;
import com.livrotech.repository.CustomeRepository;

@Service
public class CustomerService {

	private final GlobalExceptionHandler globalExceptionHandler;
	private final CustomeRepository clienteRepository;

	public CustomerService(CustomeRepository clienteRepository, GlobalExceptionHandler globalExceptionHandler) {
		this.clienteRepository = clienteRepository;
		this.globalExceptionHandler = globalExceptionHandler;
	}

	public Customer salvar(Customer cliente) {
		
		Optional<Customer> clienteExiste = clienteRepository.findByCpf(cliente.getCpf());
		
		if(clienteExiste.isPresent()) {
			Customer clienteExistente = clienteExiste.get();
			if(clienteExistente.equals(cliente)) {
				 throw new IllegalArgumentException("Cpf ja cadastrado");
			}
		}
		if(cliente.getCpf().length() < 11) {
			throw new IllegalArgumentException("Cpf deve ter 11 digitos");
		}
		if(cliente.getClass() == null) {
			throw new IllegalArgumentException("Vazio");
		} 

		return clienteRepository.save(cliente);
	}

	public List<Customer> listar() {
		return clienteRepository.findAll();
	}

	public Optional<Customer> buscarPorId(Long id) {
		return clienteRepository.findById(id);
	}
	
	public Optional<Customer> buscarPorCpf(String cpf) {
		return clienteRepository.findByCpf(cpf);
	}
}