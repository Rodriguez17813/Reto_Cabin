package com.sergioarboleda.reto_cabin.repository;

import com.sergioarboleda.reto_cabin.crud.InterfaceCabin;
import com.sergioarboleda.reto_cabin.model.Cabin;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository

public class RepositorioCabin {

    @Autowired
    private InterfaceCabin incabin;

    public List<Cabin> getAll() {
        return (List<Cabin>) incabin.findAll();
    }

    public Optional<Cabin> getCabin(int id) {
        return incabin.findById(id);
    }

    public Cabin save(Cabin cabin) {
        return incabin.save(cabin);
    }

    public void delete(Cabin cabin) {
        incabin.delete(cabin);
    }
}
