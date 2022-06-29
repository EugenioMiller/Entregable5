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
import com.example.demo.repository.ProductoRepository;

@RestController
@RequestMapping("productos")
public class ProductoController {
	
	@Qualifier("productoRepository")
    @Autowired
    private final ProductoRepository repository;

	public ProductoController(@Qualifier("productoRepository") ProductoRepository repository) {
        this.repository = repository;
    }
	
	@GetMapping("/")
    public Iterable<Producto> getProductos() {
        return repository.findAll();
    }
	
	@PostMapping("/")
    public Producto nuevoProducto(@RequestBody Producto p) {
        return repository.save(p);
    }
	
	@GetMapping("/{id}")
    Optional<Producto> one(@PathVariable int id) {
        return repository.findById((long) id);
    }

    @PutMapping("/{id}")
    Producto replacePerson(@RequestBody Producto nuevoProducto, @PathVariable int id) {

        return repository.findById((long) id)
                .map(producto -> {
                	producto.setNombre(nuevoProducto.getNombre());
                	producto.setStock(nuevoProducto.getStock());
                	producto.setPrecio(nuevoProducto.getPrecio());
                    return repository.save(producto);
                })
                .orElseGet(() -> {
                    nuevoProducto.setId(id);
                    return repository.save(nuevoProducto);
                });
    }

    @DeleteMapping("/{id}")
    void deleteCliente(@PathVariable Long id) {
        repository.deleteById(id);
    }
}
