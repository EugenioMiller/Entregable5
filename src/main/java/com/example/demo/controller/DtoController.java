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
import com.example.demo.model.Item;
import com.example.demo.model.Producto;
import com.example.demo.servicios.DTOservice;
import com.example.demo.util.ProductoDTO;

@RestController
@RequestMapping("dto") 
public class DtoController {
	
	@Autowired
    private DTOservice d;
    
	@GetMapping("/")
    public ProductoDTO items() {
        return  d.getProductoMasVendido();
    }
	
	@GetMapping("/totalPorCliente")
    public HashMap<Cliente, Float> getClientes() {
        return d.getMontoTotalPorCliente();
    }
	
	@GetMapping("/ventas/{date}")
    public ArrayList<Compra> reporteVentas(@PathVariable String date) {
		LocalDate dt = LocalDate.parse(date);
        return d.traerComprasPorDia(dt);
    }
}
