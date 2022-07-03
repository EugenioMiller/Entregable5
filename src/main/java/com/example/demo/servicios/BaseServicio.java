package com.example.demo.servicios;

import java.util.ArrayList;
import java.util.Optional;

/**
 * Interfaz base de servicio utilizada por el resto de las entidades
 * @author Aguirre Marcela, Dehesa Romina, Loiza Joaquín, Miller Eugenio
 * @version 1.0
 * @param <T> Tipo de entidad
 */
public interface BaseServicio<T> {

	/**
	 * Servicio para obtener una lista de objetos de la entidad correspondiente
	 * @return Lista 
	 */
	ArrayList<T> getAll();
	
	/**
	 * Servicio para obtener un objeto
	 * @param id de la entidad que deseamos
	 * @return Entidad 
	 */
	Optional<T> getById(int id);
	
	/**
	 * Servicio que persiste una entidad
	 * @param Entidad a persistr
	 * @return Entidad persistida
	 */
	T save(T t);
	
	/**
	 * Servivio que elimina una entidad según un id
	 * @param id de la entidad a eliminar 
	 */
	void delete (int id);
	
	/**
	 * Servicio de edición de una entidad
	 * @param Entidad modificada
	 * @param id de la entidad a modificar
	 * @return Entidad modificada
	 */
	T update(T t, int id);
}
