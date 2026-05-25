package com.livrotech.service;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.livrotech.entity.Employee;
import com.livrotech.repository.EmployeeRepository;

@Service
public class EmployeeService {

	private final EmployeeRepository funcionarioRepository;

	public EmployeeService(EmployeeRepository funcionarioRepository) {
		this.funcionarioRepository = funcionarioRepository;
	}

	public Employee salvar(Employee funcionario) {

		return funcionarioRepository.save(funcionario);
	}

	public List<Employee> listar() {
		return funcionarioRepository.findAll();
	}
	
	 public Optional<Employee> buscarPorId(Long id) {
	        return funcionarioRepository.findById(id);
	    }
}
