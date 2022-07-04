package com.example.demo.controller;

import com.example.demo.model.Cliente;
import com.example.demo.model.Compra;
import com.example.demo.servicios.ClienteService;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

/**
 * Controlador de la entidad Cliente, que nos provee acceso al service
 * de la respectiva entidad
 * @author Aguirre Marcela, Dehesa Romina, Loiza Joaquín, Miller Eugenio
 * @version 1.0
 * @see com.example.demo.model.Cliente
 */
@RestController
@RequestMapping("clientes")
@Api(value="ClienteController",description="REST API Cliente description")
public class ClienteController {


	/**
	 * @see com.example.demo.servicios.ClienteService
	 */
    @Autowired
    private final ClienteService clienteServ;

    public ClienteController(ClienteService clienteServ) {
        this.clienteServ = clienteServ;
    }

    /**
     * Método para obtener una lista de todos los clientes
     * @return Lista de clientes
     */
    @ApiOperation(value="Get list of Clients", response=Iterable.class)
    @ApiResponses(value= {
    		@ApiResponse(code=200, message="Success|Ok"),
    		@ApiResponse(code=401, message="not autorized!"),
    		@ApiResponse(code=403, message="forbidden!"),
    		@ApiResponse(code=404, message="not found"),
    		@ApiResponse(code=500, message="Error del servidor")
    		
    })
    @GetMapping("/")
    public Iterable<Cliente> getCliente() {
        return clienteServ.getAll();
    }
    
    /**
     * Función para añadir un nuevo cliente
     * @param Cliente que deseamos añadir
     * @return Cliente que añadimos
     */
    @ApiOperation(value="Create a new Client", response=Cliente.class)
    @ApiResponses(value= {
    		@ApiResponse(code=200, message="Success|Ok"),
    		@ApiResponse(code=401, message="not autorized!"),
    		@ApiResponse(code=403, message="forbidden!"),
    		@ApiResponse(code=404, message="not found"),
    		@ApiResponse(code=500, message="Error del servidor")
    		
    })
    @PostMapping("/")
    public Cliente nuevoCliente(@RequestBody Cliente c) {
        return clienteServ.save(c);
    }
    
    /**
     * Función que nos devuelve un cliente, en base a si id (dni)
     * @param dni (id del Cliente)
     * @return Cliente con id buscado
     */
    @ApiOperation(value="Get a client by DNI", response=Cliente.class)
    @ApiResponses(value= {
    		@ApiResponse(code=200, message="Success|Ok"),
    		@ApiResponse(code=401, message="not autorized!"),
    		@ApiResponse(code=403, message="forbidden!"),
    		@ApiResponse(code=404, message="not found"),
    		@ApiResponse(code=500, message="Error del servidor")
    		
    })
    @GetMapping("/{dni}")
    Optional<Cliente> one(@PathVariable int dni) {
        return clienteServ.getById(dni);
    }

    /**
     * Función para editar un cliente existente 
     * @param Cliente con los nuevos valores a editar
     * @param id del Cliente que deseamos editar 
     * @return Cliente con los nuevos atributos 
     */
    @ApiOperation(value="Update a client", response=Cliente.class)
    @ApiResponses(value= {
    		@ApiResponse(code=200, message="Success|Ok"),
    		@ApiResponse(code=401, message="not autorized!"),
    		@ApiResponse(code=403, message="forbidden!"),
    		@ApiResponse(code=404, message="not found"),
    		@ApiResponse(code=500, message="Error del servidor")
    		
    })
    
    @PutMapping("/{id}")
    Cliente replaceCliente(@RequestBody Cliente nuevoCliente, @PathVariable int id) {
    	return clienteServ.update(nuevoCliente, id);
    }
    
    /**
     * Función para editar un cliente existente 
     * @param Cliente con los nuevos valores a editar
     * @param id del Cliente que deseamos editar 
     * @return Cliente con los nuevos atributos 
     */
    @ApiOperation(value="Update a client", response=Cliente.class)
    @ApiResponses(value= {
    		@ApiResponse(code=200, message="Success|Ok"),
    		@ApiResponse(code=401, message="not autorized!"),
    		@ApiResponse(code=403, message="forbidden!"),
    		@ApiResponse(code=404, message="not found"),
    		@ApiResponse(code=500, message="Error del servidor")
    		
    })
    @PutMapping("/comprar/{id}")
    Cliente comprar(@RequestBody Compra compra, @PathVariable int id) {
    	return clienteServ.comprar(compra, id);
    }

    /**
     * Función para eliminar un cliente con un id determinado
     * @param id del cliente que deseamos eliminar 
     */
    @ApiOperation(value="Delete a client by DNI")
    @ApiResponses(value= {
    		@ApiResponse(code=200, message="Success|Ok"),
    		@ApiResponse(code=401, message="not autorized!"),
    		@ApiResponse(code=403, message="forbidden!"),
    		@ApiResponse(code=404, message="not found"),
    		@ApiResponse(code=500, message="Error del servidor")
    		
    })
    @DeleteMapping("/{id}")
    void deleteCliente(@PathVariable int id) {
    	clienteServ.delete(id);
    }
}