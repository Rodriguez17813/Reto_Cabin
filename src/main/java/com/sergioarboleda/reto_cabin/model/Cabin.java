//paquete del reto3 que contiene las clases modelos del proyecto
package com.sergioarboleda.reto_cabin.model;
//importe de librerias necesarias para que usar algunos metodos

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import java.io.Serializable;
import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
//assignacion del nombre de la tabla registrada en la DB

@Entity
@Table(name = "cabin")
//clase publica implementada y serializada
public class Cabin implements Serializable {
//creacion de las variables

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    /*ID de Cabaña*/
    private String name;
    /*Nombre de Cabaña*/
    private String brand;
    /*Marma de Cabaña*/
    private Integer rooms;
    /*Habitaciones de Cabaña*/
    private String description;
    /*Descripcion de Cabaña*/

 /*Relacion de Cabaña y categoria*/
    @ManyToOne
    @JoinColumn(name = "categoryId")
    @JsonIgnoreProperties("cabins")
    private Categoria category;

    /*Relacion de Cabaña y cliente*/
    @OneToMany(cascade = {CascadeType.PERSIST}, mappedBy = "cabin")
    @JsonIgnoreProperties({"cabin", "client"})
    private List<Mensaje> messages;

    /*Relacion de Cabaña y categoria*/
    @OneToMany(cascade = {CascadeType.PERSIST}, mappedBy = "cabin")
    @JsonIgnoreProperties({"cabin", "client"})
    private List<Reservaciones> reservations;

    /*Metdodo Get */
    public Integer getId() {
        return id;
    }

    /*Metdodo Set */
    public void setId(Integer id) {
        this.id = id;
    }

    /*Metdodo Get */
    public String getName() {
        return name;
    }

    /*Metdodo Set */
    public void setName(String name) {
        this.name = name;
    }

    /*Metdodo Get */
    public String getBrand() {
        return brand;
    }

    /*Metdodo Set */
    public void setBrand(String brand) {
        this.brand = brand;
    }

    /*Metdodo Get */
    public Integer getRooms() {
        return rooms;
    }

    /*Metdodo Set */
    public void setRooms(Integer rooms) {
        this.rooms = rooms;
    }

    /*Metdodo Get */
    public String getDescription() {
        return description;
    }

    /*Metdodo Set */
    public void setDescription(String description) {
        this.description = description;
    }

    /*Metdodo Get */
    public Categoria getCategory() {
        return category;
    }

    /*Metdodo Set */
    public void setCategory(Categoria category) {
        this.category = category;
    }

    /*Metdodo Get */
    public List<Mensaje> getMessages() {
        return messages;
    }

    /*Metdodo Set */
    public void setMessages(List<Mensaje> messages) {
        this.messages = messages;
    }

    /*Metdodo Get */
    public List<Reservaciones> getReservations() {
        return reservations;
    }

    /*Metdodo Set */
    public void setReservations(List<Reservaciones> reservations) {
        this.reservations = reservations;
    }
}
