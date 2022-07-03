package com.example.demo.servicios;

import java.util.ArrayList;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.model.Item;
import com.example.demo.repository.ItemRepository;
import com.example.demo.util.ProductoDTO;

/**
 * Servicio de la entidad Item
 * @author Aguirre Marcela, Dehesa Romina, Loiza Joaquín, Miller Eugenio
 * @version 1.0
 * @see com.example.demo.servicios.BaseServicio
 * @see com.example.demo.model.Item
 */
@Service
public class ItemService implements BaseServicio<Item>{

	/**
	 * @see com.example.demo.repository.ItemRepository
	 */
	@Autowired
	private ItemRepository itemRepo;
	
	/**
	 * Obtener lista de items existentes
	 * @return Lista de items
	 */
	@Override
	public ArrayList<Item> getAll() {
		return (ArrayList<Item>) itemRepo.findAll();
	}

	/**
	 * Obtener un item determinado
	 * @param id del item buscado
	 * @return Item con id especificado
	 */
	@Override
	public Optional<Item> getById(int id) {
		return itemRepo.findById(id);
	}

	/**
	 * Persistir un otem
	 * @param Item que deseamos persistir
	 * @return Item persistido
	 */
	@Override
	public Item save(Item t) {
		return itemRepo.save(t);
	}

	/**
	 * Eliminar un item
	 * @param id del item que deseamos eliminar
	 */
	@Override
	public void delete(int id) {
		itemRepo.deleteById(id);
	}

	/**
	 * Editar Item
	 * @param Item editado
	 * @param id del item que editamos
	 * @return Item editado
	 */
	@Override
	public Item update(Item t, int id) {
		@SuppressWarnings("deprecation")
		Item i = itemRepo.getById(id);
		i = t;
		itemRepo.save(i);
		return i;
	}

	/**
	 * Obtenemos el Producto mas vendido
	 * @return Producto mas vendido
	 */
	public ArrayList<ProductoDTO> getItemsConProductoMasVendidos() {
		return itemRepo.getItemsProductosMasVendido();
	}

}
