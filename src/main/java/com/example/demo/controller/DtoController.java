package com.example.demo.controller;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.HashMap;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.model.Cliente;
import com.example.demo.model.Compra;
import com.example.demo.servicios.DTOservice;
import com.example.demo.util.ProductoDTO;


/**
 * Controlador DTO, que nos provee acceso al service
 * de la respectiva entidad, para obtener los reportes
 * @author Aguirre Marcela, Dehesa Romina, Loiza Joaquín, Miller Eugenio
 * @version 1.0
 */
@RestController
@RequestMapping("dto") 
public class DtoController {
	
	/**
	 * @see com.example.demo.servicios.DTOService
	 */
	@Autowired
    private DTOservice d;
    
	/**
	 * Fucnión para obtener el producto mas vendido 
	 * @return ProductoDTO 
	 * @see com.example.demo.util.ProductoDTO
	 */
	@GetMapping("/")
    public ProductoDTO prodcutoMasVendido() {
        return  d.getProductoMasVendido();
    }
	
	/**
	 * Función para obtener por cada cliente el monto total 
	 * de las compras que realizaron
	 * @return HashMap de clientes con el gasto realizado 
	 */
	@GetMapping("/totalPorCliente")
    public HashMap<Cliente, Float> getClientes() {
        return d.getMontoTotalPorCliente();
    }
	
	/**
	 * Función para obtener las ventas dado un día determinado  
	 * @param date día seleccionado
	 * @return Lista de compras realizadas ese día 
	 */
	@GetMapping("/ventas/{date}")
    public ArrayList<Compra> reporteVentas(@PathVariable String date) {
		LocalDate dt = LocalDate.parse(date);
        return d.traerComprasPorDia(dt);
    }
}
