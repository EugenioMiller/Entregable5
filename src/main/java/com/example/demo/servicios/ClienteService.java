package com.example.demo.servicios;

import java.util.ArrayList;
import java.util.Optional;

import com.example.demo.model.Cliente;
import com.example.demo.repository.ClienteRepository;

public class ClienteService implements BaseServicio<Cliente>{

	private static ClienteRepository clienteRepo;
	@Override
	public ArrayList<Cliente> getAll() {
		return (ArrayList<Cliente>) clienteRepo.findAll();
	}

	@Override
	public Optional<Cliente> getById(int dni) {
		return clienteRepo.findById((long) dni);
	}

	@Override
	public Cliente save(Cliente t) {
		return clienteRepo.save(t);
	}

	@Override
	public void delete(int id) {
		clienteRepo.deleteById((long) id);
	}

	@Override
	public void update(Cliente t, int id) {
		
	}

}
