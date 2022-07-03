package com.example.demo.repository;
import java.time.LocalDate;
import java.util.ArrayList;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.example.demo.model.Compra;

/**
 * Repositorio de la entidad Compra
 * @author Aguirre Marcela, Dehesa Romina, Loiza Joaquín, Miller Eugenio
 * @version 1.0
 * @see com.example.demo.model.Compra
 */
@Repository
public interface CompraRepository extends JpaRepository<Compra, Integer>{
	
	/**
	 * Obtener compras por fecha determinada
	 * @param LocalDate de la fecha que deseamos buscar
	 * @return Lista de compras de la fecha correspondiente
	 */
	@Query(value = "SELECT * FROM compra c WHERE c.fecha=:d", nativeQuery = true)
	public ArrayList<Compra> getComprasByDate(LocalDate d);
}
