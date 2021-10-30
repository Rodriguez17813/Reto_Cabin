package com.sergioarboleda.reto_cabin.repository;

import com.sergioarboleda.reto_cabin.crud.InterfaceCategoria;
import com.sergioarboleda.reto_cabin.model.Categoria;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class RepositorioCategoria {

    @Autowired
    private InterfaceCategoria incategoria;

    public List<Categoria> getAll() {
        return (List<Categoria>) incategoria.findAll();
    }

    public Optional<Categoria> getCategoria(int id) {
        return incategoria.findById(id);
    }

    public Categoria save(Categoria Categoria) {
        return incategoria.save(Categoria);
    }

    public void delete(Categoria Categoria) {
        incategoria.delete(Categoria);
    }
}
