package com.example.demo.servicios;

import java.util.ArrayList;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.model.Producto;
import com.example.demo.repository.ProductoRepository;

@Service
public class ProductoService implements BaseServicio<Producto>{

	@Autowired
	private ProductoRepository produRepo;
	
	@Override
	public ArrayList<Producto> getAll() {
		return (ArrayList<Producto>) produRepo.findAll();
	}

	@Override
	public Optional<Producto> getById(int id) {
		return produRepo.findById(id);
	}

	@Override
	public Producto save(Producto t) {
		return produRepo.save(t);
	}

	@Override
	public void delete(int id) {
		produRepo.deleteById(id);
	}

	@Override
	public void update(Producto t, int id) {
		
	}

}
