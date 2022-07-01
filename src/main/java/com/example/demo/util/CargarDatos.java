package com.example.demo.util;

import com.example.demo.model.Cliente;
import com.example.demo.model.Compra;
import com.example.demo.model.Item;
import com.example.demo.model.Producto;
import com.example.demo.servicios.ClienteService;
import com.example.demo.servicios.CompraService;
import com.example.demo.servicios.ItemService;
import com.example.demo.servicios.ProductoService;

import java.util.Date;

import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
class CargarDatos {


	@Bean
    CommandLineRunner initCliente(ClienteService service) {
        return args -> {
           service.save(new Cliente((long)37380145, "Eugenio", "Miller"));
           service.save(new Cliente((long)30303030, "Leonel", "Messi"));
        };
    }
    

	@Bean
    CommandLineRunner initProducto(ProductoService service) {
        return args -> {
           service.save(new Producto("Harina", 20, 100));
           service.save(new Producto("Leche", 10, 50));
        };
	}
    
	@Bean
    CommandLineRunner initItem(ItemService service) {
        return args -> {
        	Producto p = (new Producto("Harina", 20, 100));
           service.save(new Item (p , 2));
        };
	}
    
	@SuppressWarnings("deprecation")
	@Bean
    CommandLineRunner initCompra(CompraService service) {
        return args -> {
           Compra c = new Compra (new Date(2022, 8, 22));
           c.addItem(new Item ((new Producto("Harina", 20, 100)), 2));
           service.save(c);
        };
	}
}