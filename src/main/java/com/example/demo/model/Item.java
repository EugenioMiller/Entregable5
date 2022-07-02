package com.example.demo.model;

import java.io.Serializable;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Transient;

@Entity
public class Item implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id;
	@OneToOne(cascade={CascadeType.MERGE})
	private Producto p;
	@Column
	private int cantidad;
	@ManyToOne(cascade={CascadeType.MERGE})
	@Transient
	private Compra compra;
	
	public Item() {
		
	}
	
	public Item(Producto p, int cant) {
		this.p = p;
		this.cantidad = cant;
	}
	

	public Producto getProducto() {
		return p;
	}

	public void setProducto(Producto producto) {
		this.p = producto;
	}

	public int getCantidad() {
		return cantidad;
	}

	public void setCantidad(int cantidad) {
		this.cantidad = cantidad;
	}

	public float getTotal() {
		return this.p.getPrecio() * this.cantidad;
	}
	
	

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	@Override
	public String toString() {
		return "Item [producto=" + p + ", cantidad=" + cantidad + "]";
	}
	
	
}

