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

import com.example.demo.model.Item;
import com.example.demo.servicios.ItemService;

/**
 * Controlador de la entidad Item, que nos provee acceso al service
 * de la respectiva entidad
 * @author Aguirre Marcela, Dehesa Romina, Loiza Joaquín, Miller Eugenio
 * @version 1.0
 * @see com.example.demo.model.Item
 */
@RestController
@RequestMapping("items")
public class ItemController {
	
	/**
	 * @see com.example.demo.servicios.ItenService
	 */
	@Qualifier("itemService")
    @Autowired
    private final ItemService itemServ;

	public ItemController(@Qualifier("itemService") ItemService itemServ) {
        this.itemServ = itemServ;
    }
	
	/**
	 * Función utilizada para obtener la lista de Items existentes
	 * @return Lista de Items
	 */
	@GetMapping("/")
    public Iterable<Item> getItems() {
        return itemServ.getAll();
    }
	
	/**
	 * Función que utilizamos para añadir un nuevo Item
	 * @param Item que deseamos persistir
	 * @return Item finalmente agregado
	 */
	@PostMapping("/")
    public Item nuevoItem(@RequestBody Item i) {
        return itemServ.save(i);
    }
	
	/**
	 * Función utilizada para obtener un Item con un id determinado
	 * @param id del item que deseamos obtener
	 * @return Item con el id ingresado
	 */
	@GetMapping("/{id}")
    Optional<Item> one(@PathVariable int id) {
        return itemServ.getById(id);
    }

	/**
	 * Función para editar un item 
	 * @param Item con los nuevos atributos
	 * @param id del item que estamos editando
	 * @return Item modificado
	 */
    @PutMapping("/{id}")
    Item replaceItem(@RequestBody Item nuevoItem, @PathVariable int id) {
        return itemServ.update(nuevoItem, id);
    }

    /**
     * Función para eliminar un item 
     * @param id del item que deseamos eliminar
     */
    @DeleteMapping("/{id}")
    void deleteItem(@PathVariable int id) {
        itemServ.delete(id);
    }
}
