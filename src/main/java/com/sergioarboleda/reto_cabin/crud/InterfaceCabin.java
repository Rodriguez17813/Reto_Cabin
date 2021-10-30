
package com.sergioarboleda.reto_cabin.crud;

import com.sergioarboleda.reto_cabin.model.Cabin;
import org.springframework.data.repository.CrudRepository;

public interface InterfaceCabin extends CrudRepository<Cabin,Integer>{
    
}
