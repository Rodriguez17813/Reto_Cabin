package com.sergioarboleda.reto_cabin.repository;

import com.sergioarboleda.reto_cabin.crud.InterfaceReservaciones;
import com.sergioarboleda.reto_cabin.model.Cliente;
import com.sergioarboleda.reto_cabin.model.Reservaciones;
import com.sergioarboleda.reto_cabin.reportes.ContadorClientes;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class RepositorioReservaciones {

    @Autowired
    private InterfaceReservaciones inreservaciones;

    public List<Reservaciones> getAll() {
        return (List<Reservaciones>) inreservaciones.findAll();
    }

    public Optional<Reservaciones> getReservation(int id) {
        return inreservaciones.findById(id);
    }

    public Reservaciones save(Reservaciones reservation) {
        return inreservaciones.save(reservation);
    }

    public void delete(Reservaciones reservation) {
        inreservaciones.delete(reservation);
    }

    public List<Reservaciones> ReservacionStatus(String status) {
        return inreservaciones.findAllByStatus(status);
    }

    public List<Reservaciones> ReservacionTiempo(Date a, Date b) {
        return inreservaciones.findAllByStartDateAfterAndStartDateBefore(a, b);
    }

    public List<ContadorClientes> getTopClientes() {
        List<ContadorClientes> respuesta = new ArrayList<>();
        List<Object[]> report = inreservaciones.countTotalReservationsByClient();
        for (int i = 0; i < report.size(); i++) {
            respuesta.add(new ContadorClientes((Long) report.get(i)[1], (Cliente) report.get(i)[0]));
        }
        return respuesta;
    }
}