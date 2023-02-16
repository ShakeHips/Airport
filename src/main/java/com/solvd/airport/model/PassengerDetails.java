package com.solvd.airport.model;

import java.util.Objects;

public class PassengerDetails {
    private int idPassengerdetails;
    private String Bonus;
    private String country;
    private String adress;
    private int passengerId;

    public PassengerDetails(){

    }

    public PassengerDetails(int idPassengerdetails, String bonus, String country, String adress, int passengerId) {
        this.idPassengerdetails = idPassengerdetails;
        Bonus = bonus;
        this.country = country;
        this.adress = adress;
        this.passengerId = passengerId;
    }

    public int getIdPassengerdetails() {
        return idPassengerdetails;
    }

    public void setIdPassengerdetails(int idPassengerdetails) {
        this.idPassengerdetails = idPassengerdetails;
    }

    public String getBonus() {
        return Bonus;
    }

    public void setBonus(String bonus) {
        Bonus = bonus;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getAdress() {
        return adress;
    }

    public void setAdress(String adress) {
        this.adress = adress;
    }

    public int getPassengerId() {
        return passengerId;
    }

    public void setPassengerId(int passengerId) {
        this.passengerId = passengerId;
    }
}
