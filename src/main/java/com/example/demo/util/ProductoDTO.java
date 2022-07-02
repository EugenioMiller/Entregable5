package com.example.demo.util;

import com.example.demo.model.Producto;

public class ProductoDTO {
	private Producto p; 
	private long cantidad;
	
	public ProductoDTO(Producto pr, long c) {
		this.setP(pr);
		this.setCantidad(c);
	}

	public long getCantidad() {
		return cantidad;
	}

	public void setCantidad(long cantidad) {
		this.cantidad = cantidad;
	}

	public Producto getP() {
		return p;
	}

	public void setP(Producto p) {
		this.p = p;
	}
}
