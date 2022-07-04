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

import com.example.demo.model.Item;
import com.example.demo.model.Producto;
import com.example.demo.servicios.ProductoService;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

/**
 * Controlador de la entidad Produccto, que nos provee acceso al service
 * de la respectiva entidad
 * @author Aguirre Marcela, Dehesa Romina, Loiza Joaquín, Miller Eugenio
 * @version 1.0
 * @see com.example.demo.model.Producto
 */
@RestController
@RequestMapping("productos")
@Api(value="ProductoController",description="REST API Producto description")
public class ProductoController {
	
	/**
	 * @see com.example.demo.servicios.ProductoService
	 */
	@Qualifier("productoService")
    @Autowired
    private final ProductoService produServ;

	public ProductoController(@Qualifier("productoService") ProductoService produServ) {
        this.produServ = produServ;
    }
	
	/**
	 * Función para obtener todos los productos existentes
	 * @return Lista de porductos 
	 */
	 @ApiOperation(value="Get list of Products",response=Iterable.class)
	    @ApiResponses(value= {
	    		@ApiResponse(code=200, message="Success|Ok"),
	    		@ApiResponse(code=401, message="not autorized!"),
	    		@ApiResponse(code=403, message="forbidden!"),
	    		@ApiResponse(code=404, message="not found"),
	    		@ApiResponse(code=500, message="Error del servidor")
	    		
	    })
	@GetMapping("/")
    public Iterable<Producto> getProductos() {
        return produServ.getAll();
    }
	
	/**
	 * Función para agregar un nuevo producto
	 * @param Producto nuevo para agregar
	 * @return Producto agregado
	 */
	 @ApiOperation(value="Create a new product", response=Item.class)
	    @ApiResponses(value= {
	    		@ApiResponse(code=200, message="Success|Ok"),
	    		@ApiResponse(code=401, message="not autorized!"),
	    		@ApiResponse(code=403, message="forbidden!"),
	    		@ApiResponse(code=404, message="not found"),
	    		@ApiResponse(code=500, message="Error del servidor")
	    		
	    })
	@PostMapping("/")
    public Producto nuevoProducto(@RequestBody Producto p) {
        return produServ.save(p);
    }
	
	/**
	 * Función para obtener un producto con un id determinado
	 * @param id del producto que deseamos obtener
	 * @return Producto con id deseado
	 */
	 @ApiOperation(value="Get a product by  id", response=Producto.class)
	    @ApiResponses(value= {
	    		@ApiResponse(code=200, message="Success|Ok"),
	    		@ApiResponse(code=401, message="not autorized!"),
	    		@ApiResponse(code=403, message="forbidden!"),
	    		@ApiResponse(code=404, message="not found"),
	    		@ApiResponse(code=500, message="Error del servidor")
	    		
	    })
	@GetMapping("/{id}")
    Optional<Producto> one(@PathVariable int id) {
        return produServ.getById(id);
    }

	/**
	 * Función para editar un producto
	 * @param Producto editado
	 * @param id del producto que estamos editando
	 * @return Producto editado
	 */
	 @ApiOperation(value="Update a product", response=Producto.class)
	    @ApiResponses(value= {
	    		@ApiResponse(code=200, message="Success|Ok"),
	    		@ApiResponse(code=401, message="not autorized!"),
	    		@ApiResponse(code=403, message="forbidden!"),
	    		@ApiResponse(code=404, message="not found"),
	    		@ApiResponse(code=500, message="Error del servidor")
	    		
	    })
    @PutMapping("/{id}")
    Producto replaceProducto(@RequestBody Producto nuevoProducto, @PathVariable int id) {
        return produServ.update(nuevoProducto, id);
    }

    /**
     * Función que elimina un producto 
     * @param id del producto que deseamos eliminar 
     */
	 @ApiOperation(value="Delete a product")
	    @ApiResponses(value= {
	    		@ApiResponse(code=200, message="Success|Ok"),
	    		@ApiResponse(code=401, message="not autorized!"),
	    		@ApiResponse(code=403, message="forbidden!"),
	    		@ApiResponse(code=404, message="not found"),
	    		@ApiResponse(code=500, message="Error del servidor")
	    		
	    })
    @DeleteMapping("/{id}")
    void deleteProducto(@PathVariable int id) {
        produServ.delete(id);
    }
}
