package com.example.demo.repository;

import com.example.demo.model.Cliente;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * Repositorio de la entidad Cliente
 * @author Aguirre Marcela, Dehesa Romina, Loiza Joaquín, Miller Eugenio
 * @version 1.0
 * @see com.example.demo.model.Cliente
 */
@Repository
public interface ClienteRepository extends JpaRepository<Cliente, Long>{
	
  
}