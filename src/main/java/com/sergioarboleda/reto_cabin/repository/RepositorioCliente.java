package com.sergioarboleda.reto_cabin.repository;

import com.sergioarboleda.reto_cabin.crud.InterfaceCliente;
import com.sergioarboleda.reto_cabin.model.Cliente;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class RepositorioCliente {

    @Autowired
    private InterfaceCliente incliente;

    public List<Cliente> getAll() {
        return (List<Cliente>) incliente.findAll();
    }

    public Optional<Cliente> getCliente(int id) {
        return incliente.findById(id);
    }

    public Cliente save(Cliente cliente) {
        return incliente.save(cliente);
    }

    public void delete(Cliente cliente) {
        incliente.delete(cliente);
    }
}
