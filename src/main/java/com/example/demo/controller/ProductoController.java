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

import com.example.demo.model.Producto;
import com.example.demo.servicios.ProductoService;


@RestController
@RequestMapping("productos")
public class ProductoController {
	
	@Qualifier("productoRepository")
    @Autowired
    private final ProductoService produServ;

	public ProductoController(@Qualifier("productoRepository") ProductoService produServ) {
        this.produServ = produServ;
    }
	
	@GetMapping("/")
    public Iterable<Producto> getProductos() {
        return produServ.getAll();
    }
	
	@PostMapping("/")
    public Producto nuevoProducto(@RequestBody Producto p) {
        return produServ.save(p);
    }
	
	@GetMapping("/{id}")
    Optional<Producto> one(@PathVariable int id) {
        return produServ.getById(id);
    }

    @PutMapping("/{id}")
    Producto replaceProducto(@RequestBody Producto nuevoProducto, @PathVariable int id) {

        return produServ.getById(id)
                .map(producto -> {
                	producto.setNombre(nuevoProducto.getNombre());
                	producto.setStock(nuevoProducto.getStock());
                	producto.setPrecio(nuevoProducto.getPrecio());
                    return produServ.save(producto);
                })
                .orElseGet(() -> {
                    nuevoProducto.setId(id);
                    return produServ.save(nuevoProducto);
                });
    }

    @DeleteMapping("/{id}")
    void deleteProducto(@PathVariable int id) {
        produServ.delete(id);
    }
}
