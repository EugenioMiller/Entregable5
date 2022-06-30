package com.example.demo.servicios;

import java.util.ArrayList;
import java.util.Optional;

import com.example.demo.model.Item;
import com.example.demo.repository.ItemRepository;

public class ItemService implements BaseServicio<Item>{

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

}
