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

@RestController
@RequestMapping("items")
public class ItemController {
	
	@Qualifier("itemService")
    @Autowired
    private final ItemService itemServ;

	public ItemController(@Qualifier("itemService") ItemService itemServ) {
        this.itemServ = itemServ;
    }
	
	@GetMapping("/")
    public Iterable<Item> getItems() {
        return itemServ.getAll();
    }
	
	@PostMapping("/")
    public Item nuevoItem(@RequestBody Item i) {
        return itemServ.save(i);
    }
	
	@GetMapping("/{id}")
    Optional<Item> one(@PathVariable int id) {
        return itemServ.getById(id);
    }

    @PutMapping("/{id}")
    Item replaceItem(@RequestBody Item nuevoItem, @PathVariable int id) {

        return itemServ.getById(id)
                .map(item -> {
                	item.setProducto(nuevoItem.getProducto());
                	item.setCantidad(nuevoItem.getCantidad());
                    return itemServ.save(item);
                })
                .orElseGet(() -> {
                	nuevoItem.setId(id);
                    return itemServ.save(nuevoItem);
                });
    }

    @DeleteMapping("/{id}")
    void deleteItem(@PathVariable int id) {
        itemServ.delete(id);
    }
}
