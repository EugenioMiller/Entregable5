package com.example.demo.DTO;

import java.util.ArrayList;
import java.util.Date;

import com.example.demo.model.Compra;
import com.example.demo.servicios.CompraService;

public class ReporteVentasPorDia {
	private ArrayList<Compra> ventas; 
	
	public ReporteVentasPorDia() {
		this.ventas = new ArrayList<Compra>();
	}
	
	public ArrayList<Compra> traerComprasPorDia(Date date) {
		this.ventas.addAll(CompraService.getInstance().getAllByDate(date));
		return new ArrayList<>(this.ventas);
	}

	
}
