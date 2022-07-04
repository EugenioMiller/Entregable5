package com.example.demo.controller;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.model.Compra;
import com.example.demo.servicios.CompraService;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;



/**
 * Controlador de la entidad Compra, que nos provee acceso al service
 * de la respectiva entidad
 * @author Aguirre Marcela, Dehesa Romina, Loiza Joaquín, Miller Eugenio
 * @version 1.0
 * @see com.example.demo.model.Compra
 */
@RestController
@RequestMapping("compras")
@Api(value="CompraController",description="REST API Compra description")
public class CompraController {
	
	/**
	 * @see com.example.demo.servicios.CompraService
	 */
	@Qualifier("compraService")
	@Autowired
    private final CompraService compraServ;
	
	public CompraController(@Qualifier("compraService") CompraService compraServ) {
        this.compraServ = compraServ;
    }

	/**
	 * Función utilizada pata obtener las compras realizadas
	 * @return Lista de compras
	 */
	   @ApiOperation(value="Get list of buys",response=Iterable.class)
	    @ApiResponses(value= {
	    		@ApiResponse(code=200, message="Success|Ok"),
	    		@ApiResponse(code=401, message="not autorized!"),
	    		@ApiResponse(code=403, message="forbidden!"),
	    		@ApiResponse(code=404, message="not found"),
	    		@ApiResponse(code=500, message="Error del servidor")
	    		
	    })
	@GetMapping("/")
    public Iterable<Compra> getCompras() {
        return compraServ.getAll();
    }
	
	/**
	 * Función para agregar una nueva comrpa
	 * @param Compra que deseamos añadir
	 * @return Compra finalmente añadida
	 */
	   @ApiOperation(value="Create a new buy", response=Compra.class)
	    @ApiResponses(value= {
	    		@ApiResponse(code=200, message="Success|Ok"),
	    		@ApiResponse(code=401, message="not autorized!"),
	    		@ApiResponse(code=403, message="forbidden!"),
	    		@ApiResponse(code=404, message="not found"),
	    		@ApiResponse(code=500, message="Error del servidor")
	    		
	    })
	@PostMapping("/")
    public Compra nuevoProducto(@RequestBody Compra c) {
        return compraServ.save(c);
    }
	
	/**
	 * Función utilizada para obtener una compra según un id determinado
	 * @param id de la compra que deseamos obtener
	 * @return La compra con el id especificado
	 */
	   @ApiOperation(value="Get a buy by  id", response=Compra.class)
	    @ApiResponses(value= {
	    		@ApiResponse(code=200, message="Success|Ok"),
	    		@ApiResponse(code=401, message="not autorized!"),
	    		@ApiResponse(code=403, message="forbidden!"),
	    		@ApiResponse(code=404, message="not found"),
	    		@ApiResponse(code=500, message="Error del servidor")
	    		
	    })
	@GetMapping("/{id}")
    Optional<Compra> one(@PathVariable int id) {
        return compraServ.getById(id);
    }

	/**
	 * Función para editar una compra 
	 * @param Compra con los datos editados
	 * @param id de la compra que estamos editando
	 * @return Compra editada
	 */
	   @ApiOperation(value="Update a buy", response=Compra.class)
	    @ApiResponses(value= {
	    		@ApiResponse(code=200, message="Success|Ok"),
	    		@ApiResponse(code=401, message="not autorized!"),
	    		@ApiResponse(code=403, message="forbidden!"),
	    		@ApiResponse(code=404, message="not found"),
	    		@ApiResponse(code=500, message="Error del servidor")
	    		
	    })
    @PutMapping("/{id}")
    Compra replaceCompra(@RequestBody Compra nuevoCompra, @PathVariable int id) {
    	return compraServ.update(nuevoCompra, id);
    }

    /**
     * Función utilizada para eliminar una compra con un id determinado
     * @param id de la compra que deseamos eliminar 
     */
	   @ApiOperation(value="Delete a buy by id")
	    @ApiResponses(value= {
	    		@ApiResponse(code=200, message="Success|Ok"),
	    		@ApiResponse(code=401, message="not autorized!"),
	    		@ApiResponse(code=403, message="forbidden!"),
	    		@ApiResponse(code=404, message="not found"),
	    		@ApiResponse(code=500, message="Error del servidor")
	    		
	    })
    @DeleteMapping("/{id}")
    void deleteProducto(@PathVariable int id) {
        compraServ.delete(id);
    }
}
