
package com.sergioarboleda.reto_cabin.crud;

import com.sergioarboleda.reto_cabin.model.Cliente;
import org.springframework.data.repository.CrudRepository;


public interface InterfaceCliente extends CrudRepository<Cliente,Integer>{
    
}
