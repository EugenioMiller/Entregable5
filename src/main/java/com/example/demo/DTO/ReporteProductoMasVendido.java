package com.example.demo.DTO;

import java.util.ArrayList;

import com.example.demo.model.Producto;
import com.example.demo.servicios.CompraService;

public class ReporteProductoMasVendido {
	private Producto p;
	
	public ReporteProductoMasVendido() {
	}
	
	public void generarReporte() {
		ArrayList<Producto> aux= CompraService.getInstance().getProductoMasVendido();
		this.p = aux.get(0);
	}

	public Producto getProducto() {
		return this.p;
	}
}
