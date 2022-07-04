package com.example.demo.controller;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.HashMap;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.model.Cliente;
import com.example.demo.model.Compra;
import com.example.demo.servicios.DTOservice;
import com.example.demo.util.ProductoDTO;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;


/**
 * Controlador DTO, que nos provee acceso al service
 * de la respectiva entidad, para obtener los reportes
 * @author Aguirre Marcela, Dehesa Romina, Loiza Joaquín, Miller Eugenio
 * @version 1.0
 */
@RestController
@RequestMapping("dto") 
@Api(value="DTOController",description="REST API DTO description")
public class DtoController {
	
	/**
	 * @see com.example.demo.servicios.DTOService
	 */
	@Autowired
    private DTOservice d;
    
	/**
	 * Fucnión para obtener el producto mas vendido 
	 * @return ProductoDTO 
	 * @see com.example.demo.util.ProductoDTO
	 */
	  @ApiOperation(value="Get the best-selling product", response=ProductoDTO.class)
	    @ApiResponses(value= {
	    		@ApiResponse(code=200, message="Success|Ok"),
	    		@ApiResponse(code=401, message="not autorized!"),
	    		@ApiResponse(code=403, message="forbidden!"),
	    		@ApiResponse(code=404, message="not found"),
	    		@ApiResponse(code=500, message="Error del servidor")
	    		
	    })
	@GetMapping("/")
    public ProductoDTO prodcutoMasVendido() {
        return  d.getProductoMasVendido();
    }
	
	/**
	 * Función para obtener por cada cliente el monto total 
	 * de las compras que realizaron
	 * @return HashMap de clientes con el gasto realizado 
	 */
	  @ApiOperation(value="Get the total for each clients", response=HashMap.class)
	    @ApiResponses(value= {
	    		@ApiResponse(code=200, message="Success|Ok"),
	    		@ApiResponse(code=401, message="not autorized!"),
	    		@ApiResponse(code=403, message="forbidden!"),
	    		@ApiResponse(code=404, message="not found"),
	    		@ApiResponse(code=500, message="Error del servidor")
	    		
	    })
	@GetMapping("/totalPorCliente")
    public HashMap<Cliente, Float> getClientes() {
        return d.getMontoTotalPorCliente();
    }
	
	/**
	 * Función para obtener las ventas dado un día determinado  
	 * @param date día seleccionado
	 * @return Lista de compras realizadas ese día 
	 */
	  @ApiOperation(value="Getsales per day", response=HashMap.class)
	    @ApiResponses(value= {
	    		@ApiResponse(code=200, message="Success|Ok"),
	    		@ApiResponse(code=401, message="not autorized!"),
	    		@ApiResponse(code=403, message="forbidden!"),
	    		@ApiResponse(code=404, message="not found"),
	    		@ApiResponse(code=500, message="Error del servidor")
	    		
	    })
	@GetMapping("/ventas/{date}")
    public ArrayList<Compra> reporteVentas(@PathVariable String date) {
		LocalDate dt = LocalDate.parse(date);
        return d.traerComprasPorDia(dt);
    }
}
