package com.sergioarboleda.reto_cabin.repository;


import com.sergioarboleda.reto_cabin.crud.InterfaceScore;
import com.sergioarboleda.reto_cabin.model.Score;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public class RepositorioScore {

    @Autowired
    private InterfaceScore interfaceScore;

    public List<Score> getAll() {
        return (List<Score>) interfaceScore.findAll();
    }

    public Optional<Score> getScore(int id) {
        return interfaceScore.findById(id);
    }

    public Score save(Score score) {
        return interfaceScore.save(score);
    }
}
