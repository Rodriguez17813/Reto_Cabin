package com.sergioarboleda.reto_cabin.service;

import com.sergioarboleda.reto_cabin.repository.RepositorioCliente;
import com.sergioarboleda.reto_cabin.model.Cliente;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ServiciosCliente {

    @Autowired
    private RepositorioCliente repcliente;

    public List<Cliente> getAll() {
        return repcliente.getAll();
    }

    public Optional<Cliente> getClient(int clientId) {
        return repcliente.getCliente(clientId);
    }

    public Cliente save(Cliente client) {
        if (client.getIdClient() == null) {
            return repcliente.save(client);
        } else {
            Optional<Cliente> e = repcliente.getCliente(client.getIdClient());
            if (e.isEmpty()) {
                return repcliente.save(client);
            } else {
                return client;
            }
        }
    }

    public Cliente update(Cliente client) {
        if (client.getIdClient() != null) {
            Optional<Cliente> e = repcliente.getCliente(client.getIdClient());
            if (!e.isEmpty()) {
                if (client.getName() != null) {
                    e.get().setName(client.getName());
                }
                if (client.getAge() != null) {
                    e.get().setAge(client.getAge());
                }
                if (client.getPassword() != null) {
                    e.get().setPassword(client.getPassword());
                }
                repcliente.save(e.get());
                return e.get();
            } else {
                return client;
            }
        } else {
            return client;
        }
    }

    public boolean deleteClient(int clientId) {
        Boolean aBoolean = getClient(clientId).map(client -> {
            repcliente.delete(client);
            return true;
        }).orElse(false);
        return aBoolean;
    }
}