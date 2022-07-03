package com.example.demo.servicios;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.model.Compra;
import com.example.demo.repository.CompraRepository;

/**
 * Servicio de la entidad Compra
 * @author Aguirre Marcela, Dehesa Romina, Loiza Joaquín, Miller Eugenio
 * @version 1.0
 * @see com.example.demo.servicios.BaseServicio
 * @see com.example.demo.model.Compra
 */
@Service
public class CompraService implements BaseServicio<Compra> {
	
	/**
	 * @see com.example.demo.repository.CompraRepository
	 */
	@Autowired
	private CompraRepository compraRepo;

	/**
	 * Obtener lista de compras
	 * @return Lista de Compra
	 */
	@Override
	public ArrayList<Compra> getAll() {
		return (ArrayList<Compra>) compraRepo.findAll();
	}

	/**
	 * Obtener compra determinada
	 * @param id de la compra deseada
	 */
	@Override
	public Optional<Compra> getById(int id) {
		return compraRepo.findById(id);
	}

	/**
	 * Persistir una compra
	 * @param Compra a persistir
	 * @return Compra persistida
	 */
	@Override
	public Compra save(Compra t) {
		return compraRepo.save(t);
	}

	/**
	 * Eliminar una comrpa
	 * @param id de la compra que deseamos eliminar
	 */
	@Override
	public void delete(int id) {
		compraRepo.deleteById(id);
	}

	/**
	 * Editar una compra
	 * @param Compra editada
	 * @param id de la compra editada
	 * @return Compra persistida (editada)
	 */
	@Override
	public Compra update(Compra t, int id) {
		@SuppressWarnings("deprecation")
		Compra c = compraRepo.getById(id);
		c = t;
		compraRepo.save(c);
		return c;
	}
	
	/**
	 * Obtener todas las compras por fecha
	 * @param LocalDate de la fecha que deseamos conocer
	 * @return Lista de Compras con la fecha buscada
	 */
	public ArrayList<Compra> getAllByDate(LocalDate date) {
		return compraRepo.getComprasByDate(date);
	}

}
