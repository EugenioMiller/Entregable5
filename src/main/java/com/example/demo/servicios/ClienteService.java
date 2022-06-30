package com.example.demo.servicios;

import java.util.ArrayList;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.model.Cliente;
import com.example.demo.repository.ClienteRepository;

@Service
public class ClienteService implements BaseServicio<Cliente>{

	@Autowired
	private static ClienteRepository clienteRepo;
	
	private static ClienteService clienteService;
	
	public static ClienteService getInstance() {
		if(clienteService == null) {
			clienteService = new ClienteService();
		}
		return clienteService;
	}
	
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
