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
	 * @return ArrayList de un cliente y su gasto 
	 */
	public ArrayList<String> getMontoTotalPorCliente() {
		ArrayList<String> total = new ArrayList<>();
		ArrayList<Cliente> clientes = cls.getAll();
		for(Cliente c : clientes) {
			total.add("El cliente = " + c.getNombre() + " hizo un monto total de = "+ c.getMontoTotal());
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
