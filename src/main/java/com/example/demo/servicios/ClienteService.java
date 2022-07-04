package com.example.demo.servicios;

import java.util.ArrayList;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.model.Cliente;
import com.example.demo.model.Compra;
import com.example.demo.repository.ClienteRepository;

/**
 * Servicio de la entidad Cliente
 * @author Aguirre Marcela, Dehesa Romina, Loiza Joaquín, Miller Eugenio
 * @version 1.0
 * @see com.example.demo.servicios.BaseServicio
 * @see com.example.demo.model.Cliente
 */
@Service
public class ClienteService implements BaseServicio<Cliente>{

	/**
	 * @see com.example.demo.repository.ClienteRepository
	 */
	@Autowired
	private ClienteRepository clienteRepo;
	
	/**
	 * Obtener lista de Clientes
	 * @return Lista clientes
	 */
	@Override
	public ArrayList<Cliente> getAll() {
		return (ArrayList<Cliente>) clienteRepo.findAll();
	}

	/**
	 * Obtener un cliente
	 * @param id del cliente que deseamos obtener
	 */
	@Override
	public Optional<Cliente> getById(int dni) {
		return clienteRepo.findById((long) dni);
	}

	/**
	 * Persisti un cliente
	 * @param Cliente que deseamos persistir
	 * @return Cliente persistido 
	 */
	@Override
	public Cliente save(Cliente t) {
		return clienteRepo.save(t);
	}

	/**
	 * Eliminar Cliente
	 * @param id del cliente que deseamos eliminar
	 */
	@Override
	public void delete(int id) {
		clienteRepo.deleteById((long) id);
	}

	/**
	 * Editar cliente
	 * @param Cliente editado
	 * @param id del cliente editado
	 * @return Cliente editado
	 */
	@Override
	public Cliente update(Cliente t, int id) {
		@SuppressWarnings("deprecation")
		Cliente c = clienteRepo.getById((long)id);
		c = t;
		clienteRepo.save(c);
		return c;
	}

	public Cliente comprar(Compra compra, int x) {
		@SuppressWarnings("deprecation")
		Cliente c = clienteRepo.getById((long)x);
		c.addCompra(compra);
		clienteRepo.save(c);
		return c;
	}

}
