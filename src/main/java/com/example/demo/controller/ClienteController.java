package com.example.demo.controller;

import com.example.demo.model.Cliente;
import com.example.demo.servicios.ClienteService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("clientes")

public class ClienteController {

    @Qualifier("clienteService")
    @Autowired
    private final ClienteService clienteServ;

    public ClienteController(@Qualifier("clienteService") ClienteService clienteServ) {
        this.clienteServ = clienteServ;
    }

    @GetMapping("/")
    public Iterable<Cliente> getCliente() {
        return clienteServ.getAll();
    }

    @PostMapping("/")
    public Cliente nuevoCliente(@RequestBody Cliente c) {
        return clienteServ.save(c);
    }

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