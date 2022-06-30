package com.example.demo.servicios;

import java.util.ArrayList;
import java.util.Optional;

import com.example.demo.model.Producto;
import com.example.demo.repository.ProductoRepository;

public class ProductoService implements BaseServicio<Producto>{

	private ProductoRepository produRepo;
	
	@Override
	public ArrayList<Producto> getAll() {
		return (ArrayList<Producto>) produRepo.findAll();
	}

	@Override
	public Optional<Producto> getById(int id) {
		return produRepo.findById((long) id);
	}

	@Override
	public Producto save(Producto t) {
		return produRepo.save(t);
	}

	@Override
	public void delete(int id) {
		produRepo.deleteById((long) id);
	}

	@Override
	public void update(Producto t, int id) {
		
	}

}
