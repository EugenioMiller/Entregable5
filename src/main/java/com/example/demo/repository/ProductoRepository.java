package com.example.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.model.Producto;

/**
 * Repositorio de la entidad Producto
 * @author Aguirre Marcela, Dehesa Romina, Loiza Joaquín, Miller Eugenio
 * @version 1.0
 * @see com.example.demo.model.Producto
 */
@Repository
public interface ProductoRepository extends JpaRepository<Producto, Integer>{

}
