package com.example.demo.servicios;

import java.util.ArrayList;
import java.util.Optional;


public interface BaseServicio<T> {

	ArrayList<T> getAll();
	
	Optional<T> getById(int id);
	
	T save(T t);
	
	void delete (int id);
	
	void update(T t, int id);
}
