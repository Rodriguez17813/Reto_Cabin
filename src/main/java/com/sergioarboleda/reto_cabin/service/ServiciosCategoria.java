package com.sergioarboleda.reto_cabin.service;

import com.sergioarboleda.reto_cabin.repository.RepositorioCategoria;
import com.sergioarboleda.reto_cabin.model.Categoria;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ServiciosCategoria {

    @Autowired
    private RepositorioCategoria repcategoria;

    public List<Categoria> getAll() {
        return repcategoria.getAll();
    }

    public Optional<Categoria> getCategoria(int CategoriaId) {
        return repcategoria.getCategoria(CategoriaId);
    }

    public Categoria save(Categoria categoria) {
        if (categoria.getId() == null) {
            return repcategoria.save(categoria);
        } else {
            Optional<Categoria> categoria1 = repcategoria.getCategoria(categoria.getId());
            if (categoria1.isEmpty()) {
                return repcategoria.save(categoria);
            } else {
                return categoria;
            }
        }
    }

    public Categoria update(Categoria categoria) {
        if (categoria.getId() != null) {
            Optional<Categoria> g = repcategoria.getCategoria(categoria.getId());
            if (!g.isEmpty()) {
                if (categoria.getDescription() != null) {
                    g.get().setDescription(categoria.getDescription());
                }
                if (categoria.getName() != null) {
                    g.get().setName(categoria.getName());
                }
                return repcategoria.save(g.get());
            }
        }
        return categoria;
    }

    public boolean deletecategoria(int categoriaId) {
        Boolean d = getCategoria(categoriaId).map(categoria -> {
            repcategoria.delete(categoria);
            return true;
        }).orElse(false);
        return d;
    }
}