package com.sergioarboleda.reto_cabin.service;

import com.sergioarboleda.reto_cabin.repository.RepositorioCabin;
import com.sergioarboleda.reto_cabin.model.Cabin;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service

public class ServiciosCabin {

    @Autowired
    private RepositorioCabin repocabin;

    public List<Cabin> getAll() {
        return repocabin.getAll();
    }

    public Optional<Cabin> getCabin(int cabinId) {
        return repocabin.getCabin(cabinId);
    }

    public Cabin save(Cabin cabin) {
        if (cabin.getId() == null) {
            return repocabin.save(cabin);
        } else {
            Optional<Cabin> e = repocabin.getCabin(cabin.getId());
            if (e.isEmpty()) {
                return repocabin.save(cabin);
            } else {
                return cabin;
            }
        }
    }

    public Cabin update(Cabin cabin) {
        if (cabin.getId() != null) {
            Optional<Cabin> e = repocabin.getCabin(cabin.getId());
            if (!e.isEmpty()) {
                if (cabin.getName() != null) {
                    e.get().setName(cabin.getName());
                }
                if (cabin.getBrand() != null) {
                    e.get().setBrand(cabin.getBrand());
                }
                if (cabin.getRooms() != null) {
                    e.get().setRooms(cabin.getRooms());
                }
                if (cabin.getDescription() != null) {
                    e.get().setDescription(cabin.getDescription());
                }
                if (cabin.getCategory() != null) {
                    e.get().setCategory(cabin.getCategory());
                }
                repocabin.save(e.get());
                return e.get();
            } else {
                return cabin;
            }
        } else {
            return cabin;
        }
    }

    public boolean deleteCabin(int cabinId) {
        Boolean aBoolean = getCabin(cabinId).map(cabin -> {
            repocabin.delete(cabin);
            return true;
        }).orElse(false);
        return aBoolean;
    }
}
