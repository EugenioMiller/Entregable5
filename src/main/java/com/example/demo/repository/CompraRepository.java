package com.example.demo.repository;
import java.util.ArrayList;
import java.util.Date;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.example.demo.model.Compra;
import com.example.demo.model.Producto;

public interface CompraRepository extends JpaRepository<Compra, Long>{
	
	@Query(value = "SELECT * FROM compras WHERE date=:d", nativeQuery = true)
	public ArrayList<Compra> getComprasByDate(Date d);

	@Query(value = "SELECT count(i.producto) FROM Item i GROUP BY i.producto ORDER BY DESC LIMIT 1", nativeQuery = true)
	public ArrayList<Producto> getProductoMasVendido();
}
