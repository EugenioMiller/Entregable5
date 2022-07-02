package com.example.demo.repository;
import java.time.LocalDate;
import java.util.ArrayList;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.example.demo.model.Compra;

@Repository
public interface CompraRepository extends JpaRepository<Compra, Long>{
	
	@Query(value = "SELECT * FROM compra c WHERE c.fecha=:d", nativeQuery = true)
	public ArrayList<Compra> getComprasByDate(LocalDate d);
}
