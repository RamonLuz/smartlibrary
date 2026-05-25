package com.livrotech.service;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.livrotech.entity.Customer;
import com.livrotech.entity.Sale;
import com.livrotech.repository.CustomeRepository;
import com.livrotech.repository.SaleRepository;

@Service
public class SaleService {

	private final CustomeRepository clienteRepository;
	private final SaleRepository vendaRepository;

	public SaleService(SaleRepository vendaRepository, CustomeRepository customeRepository) {
		this.vendaRepository = vendaRepository;
		this.clienteRepository = customeRepository;
	}

	public List<Sale> listar() {
		return vendaRepository.findAll();
	}

	public Optional<Sale> buscarPorId(Long id) {
		return vendaRepository.findById(id);
	}

	public Sale salvar(Sale venda) {
		sincronizarCliente(venda);
		Sale vendaSalva = vendaRepository.save(venda);

		return vendaSalva;
	}
	
	private void sincronizarCliente(Sale venda) {
		Optional<Customer> clienteExiste = clienteRepository.findByCpf(venda.getCliente().getCpf());

		Customer cliente = null;

		if (clienteExiste.isPresent()) {

			cliente = clienteExiste.get();
			cliente.getCompras().add(venda);

		}
		
	}

}
