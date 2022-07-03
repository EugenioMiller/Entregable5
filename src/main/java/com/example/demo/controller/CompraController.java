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


/**
 * Controlador de la entidad Compra, que nos provee acceso al service
 * de la respectiva entidad
 * @author Aguirre Marcela, Dehesa Romina, Loiza Joaquín, Miller Eugenio
 * @version 1.0
 * @see com.example.demo.model.Compra
 */
@RestController
@RequestMapping("compras")
public class CompraController {
	
	/**
	 * @see com.example.demo.servicios.CompraService
	 */
	@Qualifier("compraService")
	@Autowired
    private final CompraService compraServ;
	
	public CompraController(@Qualifier("compraService") CompraService compraServ) {
        this.compraServ = compraServ;
    }

	/**
	 * Función utilizada pata obtener las compras realizadas
	 * @return Lista de compras
	 */
	@GetMapping("/")
    public Iterable<Compra> getCompras() {
        return compraServ.getAll();
    }
	
	/**
	 * Función para agregar una nueva comrpa
	 * @param Compra que deseamos añadir
	 * @return Compra finalmente añadida
	 */
	@PostMapping("/")
    public Compra nuevoProducto(@RequestBody Compra c) {
        return compraServ.save(c);
    }
	
	/**
	 * Función utilizada para obtener una compra según un id determinado
	 * @param id de la compra que deseamos obtener
	 * @return La compra con el id especificado
	 */
	@GetMapping("/{id}")
    Optional<Compra> one(@PathVariable int id) {
        return compraServ.getById(id);
    }

	/**
	 * Función para editar una compra 
	 * @param Compra con los datos editados
	 * @param id de la compra que estamos editando
	 * @return Compra editada
	 */
    @PutMapping("/{id}")
    Compra replaceCompra(@RequestBody Compra nuevoCompra, @PathVariable int id) {
    	return compraServ.update(nuevoCompra, id);
    }

    /**
     * Función utilizada para eliminar una compra con un id determinado
     * @param id de la compra que deseamos eliminar 
     */
    @DeleteMapping("/{id}")
    void deleteProducto(@PathVariable int id) {
        compraServ.delete(id);
    }
}
