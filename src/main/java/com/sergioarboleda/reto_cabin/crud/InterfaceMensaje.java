
package com.sergioarboleda.reto_cabin.crud;

import com.sergioarboleda.reto_cabin.model.Mensaje;
import org.springframework.data.repository.CrudRepository;

public interface InterfaceMensaje extends CrudRepository<Mensaje,Integer>{
    
}
