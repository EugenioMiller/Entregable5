package com.example.demo.controller;

import com.example.demo.model.Cliente;
import com.example.demo.servicios.ClienteService;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("clientes")
@Api(value="ClienteController",description="REST API Cliente description")
public class ClienteController {


    @Autowired
    private final ClienteService clienteServ;

    public ClienteController(ClienteService clienteServ) {
        this.clienteServ = clienteServ;
    }
    @ApiOperation(value="Get list of Clients", response=Iterable.class)
    @ApiResponses(value= {
    		@ApiResponse(code=200, message="Success|Ok"),
    		@ApiResponse(code=401, message="not autorized!"),
    		@ApiResponse(code=403, message="forbidden!"),
    		@ApiResponse(code=404, message="not found"),
    		
    })
    @GetMapping("/")
    public Iterable<Cliente> getCliente() {
        return clienteServ.getAll();
    }
    @ApiOperation(value="Create a new Client", response=Cliente.class)
    @PostMapping("/")
    public Cliente nuevoCliente(@RequestBody Cliente c) {
        return clienteServ.save(c);
    }
    @ApiOperation(value="Get a client by DNI", response=Cliente.class)
    @ApiResponses(value= {
    		@ApiResponse(code=200, message="Success|Ok"),
    		@ApiResponse(code=401, message="not autorized!"),
    		@ApiResponse(code=403, message="forbidden!"),
    		@ApiResponse(code=404, message="not found"),
    		
    })
    @GetMapping("/{dni}")
    Optional<Cliente> one(@PathVariable int dni) {
        return clienteServ.getById(dni);
    }

    @PutMapping("/{id}")
    Cliente replaceCliente(@RequestBody Cliente nuevoCliente, @PathVariable int id) {

        return clienteServ.getById(id)
                .map(cliente -> {
                    cliente.setNombre(nuevoCliente.getNombre());
                    cliente.setApellido(nuevoCliente.getApellido());
                    return clienteServ.save(cliente);
                })
                .orElseGet(() -> {
                    nuevoCliente.setDni(id);
                    return clienteServ.save(nuevoCliente);
                });
    }

    @DeleteMapping("/{id}")
    void deleteCliente(@PathVariable int id) {
    	clienteServ.delete(id);
    }
}