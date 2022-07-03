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

/**
 * Controlador de la entidad Produccto, que nos provee acceso al service
 * de la respectiva entidad
 * @author Aguirre Marcela, Dehesa Romina, Loiza Joaquín, Miller Eugenio
 * @version 1.0
 * @see com.example.demo.model.Producto
 */
@RestController
@RequestMapping("productos")
public class ProductoController {
	
	/**
	 * @see com.example.demo.servicios.ProductoService
	 */
	@Qualifier("productoService")
    @Autowired
    private final ProductoService produServ;

	public ProductoController(@Qualifier("productoService") ProductoService produServ) {
        this.produServ = produServ;
    }
	
	/**
	 * Función para obtener todos los productos existentes
	 * @return Lista de porductos 
	 */
	@GetMapping("/")
    public Iterable<Producto> getProductos() {
        return produServ.getAll();
    }
	
	/**
	 * Función para agregar un nuevo producto
	 * @param Producto nuevo para agregar
	 * @return Producto agregado
	 */
	@PostMapping("/")
    public Producto nuevoProducto(@RequestBody Producto p) {
        return produServ.save(p);
    }
	
	/**
	 * Función para obtener un producto con un id determinado
	 * @param id del producto que deseamos obtener
	 * @return Producto con id deseado
	 */
	@GetMapping("/{id}")
    Optional<Producto> one(@PathVariable int id) {
        return produServ.getById(id);
    }

	/**
	 * Función para editar un producto
	 * @param Producto editado
	 * @param id del producto que estamos editando
	 * @return Producto editado
	 */
    @PutMapping("/{id}")
    Producto replaceProducto(@RequestBody Producto nuevoProducto, @PathVariable int id) {
        return produServ.update(nuevoProducto, id);
    }

    /**
     * Función que elimina un producto 
     * @param id del producto que deseamos eliminar 
     */
    @DeleteMapping("/{id}")
    void deleteProducto(@PathVariable int id) {
        produServ.delete(id);
    }
}
