package com.example.demo.servicios;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;

import com.example.demo.model.Cliente;
import com.example.demo.model.Compra;
import com.example.demo.model.Producto;

public class DTOservice {
	private static DTOservice serv;
	
	public static DTOservice getInstance() {
		if(serv == null) {
			serv = new DTOservice();
		}
		return serv;
	}
	
	@SuppressWarnings("null")
	public HashMap<Cliente, Float> getMontoTotalPorCliente() {
		HashMap<Cliente, Float> total = null;
		ArrayList<Cliente> clientes = ClienteService.getInstance().getAll();
		for(Cliente c : clientes) {
			total.put(c, c.getMontoTotal());
		}
		return total;
		
	}
	
	public Producto getProductoMasVendido() {
		ArrayList<Producto> aux= CompraService.getInstance().getProductoMasVendido();
		Producto p = aux.get(0);
		return p;
	}
	
	public ArrayList<Compra> traerComprasPorDia(Date date) {
		ArrayList<Compra> ventas = CompraService.getInstance().getAllByDate(date);
		return ventas;
	}
}
