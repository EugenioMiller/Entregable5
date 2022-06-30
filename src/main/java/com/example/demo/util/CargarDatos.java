package com.example.demo.util;

import com.example.demo.model.Cliente;
import com.example.demo.model.Producto;
import com.example.demo.servicios.ClienteService;
import com.example.demo.servicios.ProductoService;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
@Slf4j
class CargarDatos {

    /*@Bean
    CommandLineRunner initCliete(@Qualifier("clienteService") ClienteService service) {
        return args -> {
           service.save(new Cliente((long)37380145, "Eugenio", "Miller"));
           service.save(new Cliente((long)30303030, "Leonel", "Messi"));
        };
    }
    
    @Bean
    CommandLineRunner initProducto(@Qualifier("productoService") ProductoService service) {
        return args -> {
           service.save(new Producto("Harina", 20, 100));
           service.save(new Producto("Leche", 10, 50));
        };
    }*/
    
    
}