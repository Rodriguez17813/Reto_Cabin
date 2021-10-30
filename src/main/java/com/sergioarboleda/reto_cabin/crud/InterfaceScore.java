
package com.sergioarboleda.reto_cabin.crud;

import com.sergioarboleda.reto_cabin.model.Score;
import org.springframework.data.repository.CrudRepository;


public interface InterfaceScore extends CrudRepository<Score,Integer>{
    
}
