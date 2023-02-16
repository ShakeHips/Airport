package com.solvd.airport.model;

import java.util.Objects;

public class Passenger {
    private int idPassenger;
    private String name;
    private int bookingId;
    private int luggageId;
    private int age;

    public Passenger(){
    }

    public Passenger(int idPassenger, String name, int bookingId, int luggageId, int age) {
        this.idPassenger = idPassenger;
        this.name = name;
        this.bookingId = bookingId;
        this.luggageId = luggageId;
        this.age = age;
    }

    public int getIdPassenger() {
        return idPassenger;
    }

    public void setIdPassenger(int idPassenger) {
        this.idPassenger = idPassenger;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getBookingId() {
        return bookingId;
    }

    public void setBookingId(int bookingId) {
        this.bookingId = bookingId;
    }

    public int getLuggageId() {
        return luggageId;
    }

    public void setLuggageId(int luggageId) {
        this.luggageId = luggageId;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }
}
