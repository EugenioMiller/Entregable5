package com.example.demo.model;

import java.util.ArrayList;
import java.util.Date;

public class Compra {


	private Date fechaVenta;
	private ArrayList<Item> items;
	
	public Compra() {
		
	}
	
	public Compra(Date fecha) {
		this.fechaVenta = fecha;
		this.items = new ArrayList<>();
	}

	public void addItem(Item i) {
		this.items.add(i);
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

	public float getTotal() {
		float total = 0;
		for (Item i: items) {
			total+= i.getTotal();
		}
		
		return total;
	}

	@Override
	public String toString() {
		return "Compra [items=" + items + "]";
	}
	
	
}
