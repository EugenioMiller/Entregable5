package com.example.demo.model;

public class Item {

	private Producto producto;
	private int cantidad;
	
	public Item() {
		
	}
	
	public Item(Producto p, int cant) {
		this.producto = p;
		this.cantidad = cant;
	}

	public Producto getProducto() {
		return producto;
	}

	public void setProducto(Producto producto) {
		this.producto = producto;
	}

	public int getCantidad() {
		return cantidad;
	}

	public void setCantidad(int cantidad) {
		this.cantidad = cantidad;
	}

	public float getTotal() {
		return this.producto.getPrecio() * this.cantidad;
	}

	@Override
	public String toString() {
		return "Item [producto=" + producto + ", cantidad=" + cantidad + "]";
	}
	
	
}

