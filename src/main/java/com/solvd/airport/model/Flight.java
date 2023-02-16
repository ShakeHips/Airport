package com.solvd.airport.model;

import java.util.Objects;

public class Flight {
    private int idFlight;
    private String Departure;
    private String Arrival;
    private int employeeId;
    private int flightlogId;
    private int airplaneId;
    private int airlineId;
    private int airportId;

    public Flight(){

    }

    public Flight(int idFlight, String departure, String arrival, int employeeId, int flightlogId, int airplaneId, int airlineId, int airportId) {
        this.idFlight = idFlight;
        Departure = departure;
        Arrival = arrival;
        this.employeeId = employeeId;
        this.flightlogId = flightlogId;
        this.airplaneId = airplaneId;
        this.airlineId = airlineId;
        this.airportId = airportId;
    }

    public int getIdFlight() {
        return idFlight;
    }

    public void setIdFlight(int idFlight) {
        this.idFlight = idFlight;
    }

    public String getDeparture() {
        return Departure;
    }

    public void setDeparture(String departure) {
        Departure = departure;
    }

    public String getArrival() {
        return Arrival;
    }

    public void setArrival(String arrival) {
        Arrival = arrival;
    }

    public int getEmployeeId() {
        return employeeId;
    }

    public void setEmployeeId(int employeeId) {
        this.employeeId = employeeId;
    }

    public int getFlightlogId() {
        return flightlogId;
    }

    public void setFlightlogId(int flightlogId) {
        this.flightlogId = flightlogId;
    }

    public int getAirplaneId() {
        return airplaneId;
    }

    public void setAirplaneId(int airplaneId) {
        this.airplaneId = airplaneId;
    }

    public int getAirlineId() {
        return airlineId;
    }

    public void setAirlineId(int airlineId) {
        this.airlineId = airlineId;
    }

    public int getAirportId() {
        return airportId;
    }

    public void setAirportId(int airportId) {
        this.airportId = airportId;
    }
}
