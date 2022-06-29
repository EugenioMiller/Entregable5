package com.example.demo.DTO;

import java.util.ArrayList;
import java.util.HashMap;

import com.example.demo.model.Cliente;
import com.example.demo.repository.ClienteRepository;

public class DTOTotalPorCliente {

	private ClienteRepository clienteRepo;
	private HashMap<Cliente, Float> total;
	
	public void generarDto() {
		ArrayList<Cliente> clientes = (ArrayList<Cliente>) clienteRepo.findAll();
		
		for(Cliente c : clientes) {
			total.put(c, c.getMontoTotal());
		}
	}
	
	public HashMap<Cliente, Float> getClientesPrecio(){
		return new HashMap<Cliente, Float>(this.total);
	}
}
