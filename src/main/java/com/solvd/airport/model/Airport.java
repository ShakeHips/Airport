package com.solvd.airport.model;

import java.util.Objects;

public class Airport {
    private int idAirport;
    private String name;
    private String location;

    public Airport(){

    }

    public Airport(int idAirport, String name, String location){
        this.idAirport = idAirport;
        this.name = name;
        this.location = location;
    }

    public int getIdAirport() {
        return idAirport;
    }

    public void setIdAirport(int idAirport) {
        this.idAirport = idAirport;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }
}
