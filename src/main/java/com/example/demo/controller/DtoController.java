package com.example.demo.controller;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.model.Cliente;
import com.example.demo.model.Compra;
import com.example.demo.model.Producto;
import com.example.demo.servicios.DTOservice;

@RestController
@RequestMapping("dto") 
public class DtoController {
	
	@GetMapping("/totalPorCliente")
    public HashMap<Cliente, Float> getClientes() {
        return DTOservice.getInstance().getMontoTotalPorCliente();
    }
	@GetMapping("/ventas/{date}")
    public ArrayList<Compra> reporteVentas(@PathVariable Date date) {
        return DTOservice.getInstance().traerComprasPorDia(date);
    }
	@GetMapping("/productomasvendido")
    public Producto getCliente() {
        return DTOservice.getInstance().getProductoMasVendido();
    }
}
