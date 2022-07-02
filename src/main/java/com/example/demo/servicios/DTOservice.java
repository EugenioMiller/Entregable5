package com.example.demo.servicios;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.HashMap;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.model.Cliente;
import com.example.demo.model.Compra;
import com.example.demo.model.Item;
import com.example.demo.model.Producto;
import com.example.demo.util.ProductoDTO;

@Service
public class DTOservice {
	
	@Autowired
	private ClienteService cls;
	
	@Autowired
	private CompraService cms;
	
	@Autowired
	private ItemService is;
	
	
	public HashMap<Cliente, Float> getMontoTotalPorCliente() {
		HashMap<Cliente, Float> total = new HashMap<>();
		ArrayList<Cliente> clientes = cls.getAll();
		for(Cliente c : clientes) {
			total.put(c, c.getMontoTotal());
		}
		return total;
		
	}
	
	public ArrayList<Compra> traerComprasPorDia(LocalDate date) {
		ArrayList<Compra> ventas = cms.getAllByDate(date);
		return ventas;
	}

	public ProductoDTO getProductoMasVendido() {
		return is.getItemsConProductoMasVendidos().get(0);
	}
}
