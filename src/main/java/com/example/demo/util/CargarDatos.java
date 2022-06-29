package com.example.demo.util;

import com.example.demo.model.Cliente;
import com.example.demo.model.Producto;
import com.example.demo.repository.ClienteRepository;
import com.example.demo.repository.ProductoRepository;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
@Slf4j
class CargarDatos {

    @Bean
    CommandLineRunner initCliete(@Qualifier("clienteRepository") ClienteRepository repository) {
        return args -> {
           repository.save(new Cliente((long)37380145, "Eugenio", "Miller"));
           repository.save(new Cliente((long)30303030, "Leonel", "Messi"));
        };
    }
    
    @Bean
    CommandLineRunner initProducto(@Qualifier("productoRepository") ProductoRepository repository) {
        return args -> {
           repository.save(new Producto("Harina", 20, 100));
           repository.save(new Producto("Leche", 10, 50));
        };
    }
    
    
}