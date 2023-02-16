package com.solvd.airport.model;

import java.util.Objects;

public class Airline {
    private int idAirline;
    private String name;
    private int airportId;

    public Airline() {

    }

    public Airline(int idAirline, String name, int airportId) {
        this.idAirline = idAirline;
        this.name = name;
        this.airportId = airportId;
    }

    public int getIdAirline() {
        return idAirline;
    }

    public void setIdAirline(int idAirline) {
        this.idAirline = idAirline;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAirportId() {
        return airportId;
    }

    public void setAirportId(int airportId) {
        this.airportId = airportId;
    }
}
