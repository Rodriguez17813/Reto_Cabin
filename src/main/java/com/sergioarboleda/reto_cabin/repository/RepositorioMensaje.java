package com.sergioarboleda.reto_cabin.repository;

import com.sergioarboleda.reto_cabin.crud.InterfaceMensaje;
import com.sergioarboleda.reto_cabin.model.Mensaje;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class RepositorioMensaje {

    @Autowired
    private InterfaceMensaje inmensaje;

    public List<Mensaje> getAll() {
        return (List<Mensaje>) inmensaje.findAll();
    }

    public Optional<Mensaje> getMessage(int id) {
        return inmensaje.findById(id);
    }

    public Mensaje save(Mensaje message) {
        return inmensaje.save(message);
    }

    public void delete(Mensaje message) {
        inmensaje.delete(message);
    }
}
