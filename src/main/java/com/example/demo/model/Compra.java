package com.example.demo.model;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;


@Entity
public class Compra {

	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id;
	@Column
	private Date fechaVenta;
	@OneToMany(cascade={CascadeType.ALL})
	
	private List<Item> items;
	
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
	public void setId(int id) {
		this.id=id;
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
