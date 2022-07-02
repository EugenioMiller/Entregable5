package com.example.demo.servicios;

import java.util.ArrayList;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.model.Item;
import com.example.demo.model.Producto;
import com.example.demo.repository.ItemRepository;
import com.example.demo.util.ProductoDTO;

@Service
public class ItemService implements BaseServicio<Item>{

	@Autowired
	private ItemRepository itemRepo;
	
	@Override
	public ArrayList<Item> getAll() {
		return (ArrayList<Item>) itemRepo.findAll();
	}

	@Override
	public Optional<Item> getById(int id) {
		return itemRepo.findById(id);
	}

	@Override
	public Item save(Item t) {
		return itemRepo.save(t);
	}

	@Override
	public void delete(int id) {
		itemRepo.deleteById(id);
	}

	@Override
	public void update(Item t, int id) {
	
	}

	public ArrayList<ProductoDTO> getItemsConProductoMasVendidos() {
		return itemRepo.getItemsProductosMasVendido();
	}

}
