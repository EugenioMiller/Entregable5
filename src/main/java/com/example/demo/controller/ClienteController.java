package com.example.demo.controller;

import com.example.demo.model.Cliente;
import com.example.demo.repository.ClienteRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("clientes")

public class ClienteController {

    @Qualifier("clienteRepository")
    @Autowired
    private final ClienteRepository repository;

    public ClienteController(@Qualifier("clienteRepository") ClienteRepository repository) {
        this.repository = repository;
    }

    @GetMapping("/")
    public Iterable<Cliente> getCliente() {
        return repository.findAll();
    }

 
    @GetMapping("/PorApellido/{apellido}")
    public Iterable<Cliente> getClientePorApellido(@PathVariable String apellido) {
        return repository.getClientePorApellido(apellido);
    }

    @GetMapping("/PorNombre/{nombre}")
    public Iterable<Cliente> getPersonsByName(@PathVariable String nombre) {
        return repository.findAllByName(nombre);
    }

    @PostMapping("/")
    public Cliente nuevoCliente(@RequestBody Cliente c) {
        return repository.save(c);
    }

    @RequestMapping(value = "/getCliente/{nombre}")
    public Cliente getCliente(@PathVariable(value = "name") String nombre) {
        return repository.findAllByName(nombre).get(0);
    }
    @GetMapping("/{dni}")
    Optional<Cliente> one(@PathVariable Long dni) {
        return repository.findById(dni);
    }

    @PutMapping("/{id}")
    Cliente replacePerson(@RequestBody Cliente nuevoCliente, @PathVariable Long id) {

        return repository.findById(id)
                .map(cliente -> {
                    cliente.setNombre(nuevoCliente.getNombre());
                    cliente.setApellido(nuevoCliente.getApellido());
                    return repository.save(cliente);
                })
                .orElseGet(() -> {
                    nuevoCliente.setDni(id);
                    return repository.save(nuevoCliente);
                });
    }

    @DeleteMapping("/{id}")
    void deleteCliente(@PathVariable Long id) {
        repository.deleteById(id);
    }
}