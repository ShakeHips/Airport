package com.solvd.airport.model;

import java.util.Objects;

public class Airplane {
    private int idAirplane;
    private int capacity;
    private String airline;

    public Airplane(){

    }

    public Airplane(int idAirplane, int capacity, String airline){
        this.idAirplane = idAirplane;
        this.capacity = capacity;
        this.airline = airline;
    }

    public int getIdAirplane() {
        return idAirplane;
    }

    public void setIdAirplane(int idAirplane) {
        this.idAirplane = idAirplane;
    }

    public int getCapacity() {
        return capacity;
    }

    public void setCapacity(int capacity) {
        this.capacity = capacity;
    }

    public String getAirline() {
        return airline;
    }

    public void setAirline(String airline) {
        this.airline = airline;
    }



    @Override
    public String toString() {
        return "Airplane{" +
                "idAirplane=" + idAirplane +
                ", capacity=" + capacity +
                ", airline='" + airline + '\'' +
                '}';
    }
}
