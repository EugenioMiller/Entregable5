package com.example.demo.repository;

import com.example.demo.model.Cliente;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface ClienteRepository extends JpaRepository<Cliente, Long> {

    @Query("SELECT c FROM Cliente c where c.apellido = :apellido")
    public List<Cliente> getClientePorApellido(String apellido);

    @Query("SELECT c FROM Cliente c where c.nombre = :nombre")
    public List<Cliente> findAllByName(String nombre);
}