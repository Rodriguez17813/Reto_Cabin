package com.sergioarboleda.reto_cabin.repository;

import com.sergioarboleda.reto_cabin.crud.InterfaceAdmin;
import com.sergioarboleda.reto_cabin.model.Admin;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import java.util.List;
import java.util.Optional;

@Repository
public class RepositorioAdmin {

    @Autowired
    private InterfaceAdmin interfaceAdmin;

    public List<Admin> getAll() {
        return (List<Admin>) interfaceAdmin.findAll();
    }

    public Optional<Admin> getAdmin(int id) {
        return interfaceAdmin.findById(id);
    }

    public Admin save(Admin admin) {
        return interfaceAdmin.save(admin);
    }

    public void delete(Admin admin) {
        interfaceAdmin.delete(admin);
    }
}
