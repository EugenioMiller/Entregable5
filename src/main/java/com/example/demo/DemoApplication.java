package com.example.demo;

import java.util.Date;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.example.demo.model.Cliente;
import com.example.demo.model.Compra;
import com.example.demo.model.Item;
import com.example.demo.model.Producto;

@SpringBootApplication
public class DemoApplication {

	public static void main(String[] args) {
		SpringApplication.run(DemoApplication.class, args);
		
		Producto p1 = new Producto("Cerveza", 6, 75);
		Item i1 = new Item(p1, 3);
		Cliente cl1 = new Cliente((long) 37380145, "Eugenio", "Miller");
		@SuppressWarnings("deprecation")
		Compra c = new Compra(new Date(2022, 8, 23));
		
		c.addItem(i1);
		cl1.addCompra(c);
		
		System.out.println(cl1.getCompras());
	}

}
