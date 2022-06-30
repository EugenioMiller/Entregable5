package com.example.demo.servicios;

import java.util.ArrayList;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.model.Compra;
import com.example.demo.repository.CompraRepository;


@Service
public class CompraService implements BaseServicio<Compra> {
	
	@Autowired
	private CompraRepository compraRepo;
	@Override
	public ArrayList<Compra> getAll() {
		return (ArrayList<Compra>) compraRepo.findAll();
	}

	@Override
	public Optional<Compra> getById(int id) {
		return compraRepo.findById((long) id);
	}

	@Override
	public Compra save(Compra t) {
		return compraRepo.save(t);
	}

	@Override
	public void delete(int id) {
		compraRepo.deleteById((long) id);
	}

	@Override
	public void update(Compra t, int id) {
		
	}

}
