package com.example.demo.repository;

import java.util.ArrayList;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.example.demo.model.Item;
import com.example.demo.util.ProductoDTO;

@Repository
public interface ItemRepository extends JpaRepository<Item, Integer>{
	@Query("SELECT new com.example.demo.util.ProductoDTO(m.p, SUM(m.cantidad)) FROM Item m GROUP BY m.p ORDER BY SUM(m.cantidad) DESC")
	public ArrayList<ProductoDTO> getItemsProductosMasVendido();

}
