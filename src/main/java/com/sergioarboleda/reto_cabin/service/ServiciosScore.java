
package com.sergioarboleda.reto_cabin.service;


import com.sergioarboleda.reto_cabin.model.Score;
import com.sergioarboleda.reto_cabin.repository.RepositorioScore;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service

public class ServiciosScore {
    
    @Autowired
    private RepositorioScore repositorioScore;
 
    public List<Score> getAll(){
       return repositorioScore.getAll();
    }
    
    public Score save(Score score) {
        if (score.getIdScore() == null) {
            return repositorioScore.save(score);
        } else {
            Optional<Score> scoreUno = repositorioScore.getScore(score.getIdScore());
            if (scoreUno.isEmpty()) {
                return repositorioScore.save(score);
            } else {
                return score;
            }
        }
    }
}
