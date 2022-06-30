package com.example.demo.model;

import java.util.ArrayList;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Cliente {

	@Id
	private Long dni;
	@Column
	private String nombre;
	@Column
	private String apellido;
	private ArrayList<Compra> compras;
	
	public Cliente() {
		
	}
	
	public Cliente(Long dni, String nombre, String apellido) {
		super();
		this.dni = dni;
		this.nombre = nombre;
		this.apellido = apellido;
		this.compras = new ArrayList<>();
	}

	public Long getDni() {
		return dni;
	}

	public void setDni(int id) {
		this.dni = (long) id;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getApellido() {
		return apellido;
	}

	public void setApellido(String apellido) {
		this.apellido = apellido;
	}

	public Float getMontoTotal() {
		float total = 0;
		for(Compra c : compras) {
			total += c.getTotal();
		}
		
		return total;
	}
	
	public void addCompra(Compra c) {
		this.compras.add(c);
	}

	public ArrayList<Compra> getCompras(){
		return new ArrayList<Compra>(this.compras);
	}
	
	@Override
	public String toString() {
		return "El cliente: " + this.nombre + " " + this.apellido  + " gasta un total de: ";
	}
	
	
}
