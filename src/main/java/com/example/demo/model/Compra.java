package com.example.demo.model;

import java.util.ArrayList;
import java.util.Date;

public class Compra {


	private Date fechaVenta;
	private Cliente cliente;
	private ArrayList<Item> items;
	
	public Compra() {
		
	}
	
	public Compra(Cliente c, Date fecha) {
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

	public Date getFechaVenta() {
		return fechaVenta;
	}

	public void setFechaVenta(Date fechaVenta) {
		this.fechaVenta = fechaVenta;
	}
	
	
}
