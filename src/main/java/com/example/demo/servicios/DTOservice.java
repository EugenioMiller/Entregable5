package com.example.demo.servicios;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.HashMap;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.model.Cliente;
import com.example.demo.model.Compra;
import com.example.demo.util.ProductoDTO;

/**
 * Servicio del DTO
 * @author Aguirre Marcela, Dehesa Romina, Loiza Joaquín, Miller Eugenio
 * @version 1.0
 * @see com.example.demo.servicios.BaseServicioS
 */
@Service
public class DTOservice {
	
	/**
	 * @see com.example.demo.servicios.ClienteService
	 */
	@Autowired
	private ClienteService cls;
	/**
	 * @see com.example.demo.servicios.CompraService
	 */
	@Autowired
	private CompraService cms;
	/**
	 * @see com.example.demo.servicios.ItemeService
	 */
	@Autowired
	private ItemService is;
	
	/**
	 * Función para obtener el monto de cada cliente
	 * @return HasMap de un cliente y su gasto 
	 */
	public HashMap<Cliente, Float> getMontoTotalPorCliente() {
		HashMap<Cliente, Float> total = new HashMap<>();
		ArrayList<Cliente> clientes = cls.getAll();
		for(Cliente c : clientes) {
			total.put(c, c.getMontoTotal());
		}
		return total;
		
	}
	
	/**
	 * Compras realizadas por día 
	 * @param date día que deseamos conocer
	 * @return Lista con las compras de un día determiando
	 */
	public ArrayList<Compra> traerComprasPorDia(LocalDate date) {
		ArrayList<Compra> ventas = cms.getAllByDate(date);
		return ventas;
	}

	/**
	 * Función que devuelve el producto mas vendido 
	 * @return ProductoDTO mas vendido
	 */
	public ProductoDTO getProductoMasVendido() {
		return is.getItemsConProductoMasVendidos().get(0);
	}
}
