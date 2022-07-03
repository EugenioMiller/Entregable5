package com.example.demo.util;

import com.example.demo.model.Cliente;
import com.example.demo.model.Compra;
import com.example.demo.model.Item;
import com.example.demo.model.Producto;
import com.example.demo.servicios.ClienteService;
import com.example.demo.servicios.CompraService;
import com.example.demo.servicios.ItemService;
import com.example.demo.servicios.ProductoService;

import java.time.LocalDate;

import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * Clase de creación de datos
 * @author Aguirre Marcela, Dehesa Romina, Loiza Joaquín, Miller Eugenio
 * @version 1.0
 */
@Configuration
class CargarDatos {

	/**
	 * Lógica de inserción de datos 
	 * @param sc Cliente servicio para agregar Cliente
	 * @param sp Producto servicio para agregar un producto
	 * @param si Item servicio para agregar un servicio
	 * @param cs Compra servicio para agregar una compra
	 */
	@Bean
    CommandLineRunner initCliente(ClienteService sc, ProductoService sp, ItemService si, CompraService cs) {
        return args -> {
        	Producto p = (new Producto("Harina", 20, 100));
        	Producto p1 = (new Producto("Leche", 20, 100));
        	sp.save(p);
        	sp.save(p1);
        	
        	sc.save(new Cliente((long)37380145, "Eugenio", "Miller"));
        	sc.save(new Cliente((long)30303030, "Leonel", "Messi"));
        	
        	Item i1 = new Item (p , 2);
        	si.save(i1);
        	Item i2 = new Item (p1 , 20);
        	si.save(i2);
        	Item i3 = new Item (p , 12);
        	si.save(i3);
        	
        	Compra c = new Compra (LocalDate.of(2022, 8, 22));
            c.addItem(i1);
            cs.save(c);
        };
    }
  
}