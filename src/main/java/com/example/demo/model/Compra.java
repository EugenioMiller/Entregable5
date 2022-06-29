package com.example.demo.model;

import java.util.ArrayList;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

@Entity
public class Compra {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id;
	@Column
	private Date fechaVenta;
	@ManyToOne
	private Cliente cliente;
	private ArrayList<Item> items;
	
	public Compra() {
		
	}
	
	public Compra(int id, Cliente c, Date fecha) {
		this.id = id;
		this.cliente = c;
		this.fechaVenta = fecha;
		this.items = new ArrayList<>();
	}

	public Cliente getCliente() {
		return cliente;
	}

	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}

	public ArrayList<Item> getItems() {
		return new ArrayList<Item>(this.items);
	}

	public void setItems(ArrayList<Item> items) {
		this.items = items;
	}

	public int getId() {
		return this.id;
	}

	public Date getFechaVenta() {
		return fechaVenta;
	}

	public void setFechaVenta(Date fechaVenta) {
		this.fechaVenta = fechaVenta;
	}
	
	
}
