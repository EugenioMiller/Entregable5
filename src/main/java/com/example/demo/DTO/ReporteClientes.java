package com.example.demo.DTO;

import java.util.ArrayList;
import java.util.HashMap;
import com.example.demo.model.Cliente;
import com.example.demo.servicios.ClienteService;

public class ReporteClientes {
	
	private HashMap<Cliente, Float> total;
	
	public void generarDto() {
		ArrayList<Cliente> clientes = ClienteService.getInstance().getAll();
		for(Cliente c : clientes) {
			total.put(c, c.getMontoTotal());
		}
	}
	
	public HashMap<Cliente, Float> getClientesPrecio(){
		return new HashMap<Cliente, Float>(this.total);
	}
}
