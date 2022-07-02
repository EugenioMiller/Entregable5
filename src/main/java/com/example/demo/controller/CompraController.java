package com.example.demo.controller;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.model.Compra;
import com.example.demo.servicios.CompraService;



@RestController
@RequestMapping("compras")
public class CompraController {
	@Qualifier("compraService")
    
	@Autowired
    private final CompraService compraServ;
	
	public CompraController(@Qualifier("compraService") CompraService compraServ) {
        this.compraServ = compraServ;
    }

	@GetMapping("/")
    public Iterable<Compra> getCompras() {
        return compraServ.getAll();
    }
	
	@PostMapping("/")
    public Compra nuevoProducto(@RequestBody Compra c) {
        return compraServ.save(c);
    }
	
	@GetMapping("/{id}")
    Optional<Compra> one(@PathVariable int id) {
        return compraServ.getById(id);
    }

    @PutMapping("/{id}")
    Compra replaceCompra(@RequestBody Compra nuevoCompra, @PathVariable int id) {

        return compraServ.getById(id)
                .map(compra -> {
                	compra.setFechaVenta(nuevoCompra.getFechaVenta());
                    return compraServ.save(compra);
                })
                .orElseGet(() -> {
                	nuevoCompra.setId(id);
                    return compraServ.save(nuevoCompra);
                });
    }

    @DeleteMapping("/{id}")
    void deleteProducto(@PathVariable int id) {
        compraServ.delete(id);
    }
}
