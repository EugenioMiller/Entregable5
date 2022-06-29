package com.example.demo.controller;

import java.util.HashMap;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.DTO.DTOTotalPorCliente;
import com.example.demo.model.Cliente;

@RestController
@RequestMapping("dto")
public class DtoController {

	static final DTOTotalPorCliente totalCliente = new DTOTotalPorCliente();
	
	@GetMapping("/totalPorCliente")
    public HashMap<Cliente, Float> getCliente() {
        return totalCliente.getClientesPrecio();
    }
}
