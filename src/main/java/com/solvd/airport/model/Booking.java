package com.solvd.airport.model;

import java.util.Objects;

public class Booking {
    private int idBooking;
    private int seat;
    private double price;
    private int airportId;

    public Booking(){
    }

    public Booking(int idBooking, int seat, double price,int airportId){
        this.idBooking = idBooking;
        this.seat = seat;
        this.price = price;
        this.airportId = airportId;
    }

    public int getIdBooking() {
        return idBooking;
    }

    public void setIdBooking(int idBooking) {
        this.idBooking = idBooking;
    }

    public int getSeat() {
        return seat;
    }

    public void setSeat(int seat) {
        this.seat = seat;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public int getAirportId() {
        return airportId;
    }

    public void setAirportId(int airportId) {
        this.airportId = airportId;
    }
}
