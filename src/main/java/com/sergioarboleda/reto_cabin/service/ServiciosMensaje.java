package com.sergioarboleda.reto_cabin.service;

import com.sergioarboleda.reto_cabin.repository.RepositorioMensaje;
import com.sergioarboleda.reto_cabin.model.Mensaje;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class ServiciosMensaje {

    @Autowired
    private RepositorioMensaje repmensaje;

    public List<Mensaje> getAll() {
        return repmensaje.getAll();
    }

    public Optional<Mensaje> getMessage(int messageId) {
        return repmensaje.getMessage(messageId);
    }

    public Mensaje save(Mensaje message) {
        if (message.getIdMessage() == null) {
            return repmensaje.save(message);
        } else {
            Optional<Mensaje> e = repmensaje.getMessage(message.getIdMessage());
            if (e.isEmpty()) {
                return repmensaje.save(message);
            } else {
                return message;
            }
        }
    }

    public Mensaje update(Mensaje message) {
        if (message.getIdMessage() != null) {
            Optional<Mensaje> e = repmensaje.getMessage(message.getIdMessage());
            if (!e.isEmpty()) {
                if (message.getMessageText() != null) {
                    e.get().setMessageText(message.getMessageText());
                }
                repmensaje.save(e.get());
                return e.get();
            } else {
                return message;
            }
        } else {
            return message;
        }
    }

    public boolean deleteMessage(int messageId) {
        Boolean aBoolean = getMessage(messageId).map(message -> {
            repmensaje.delete(message);
            return true;
        }).orElse(false);
        return aBoolean;
    }
}