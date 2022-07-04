package com.example.demo.model;

import java.util.ArrayList;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

import io.swagger.annotations.ApiModelProperty;

/**
 * Entidad de Cliente
 * @author Aguirre Marcela, Dehesa Romina, Loiza Joaquín, Miller Eugenio
 * @version 1.0
 */

@Entity
public class Cliente {
	@ApiModelProperty(notes="DNI of the Client",required=true)
	@Id
	private Long dni;
	@ApiModelProperty(notes="Name of the Client",required=true)
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

	/**
	 * Función que calcula el total gastado por 
	 * el cliente, en una compra
	 * @return float con el calor total gastado
	 */
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
