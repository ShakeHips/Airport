package com.solvd.airport.model;

import java.util.Objects;

public class Luggage {
    private int idLuggage;
    private String weight;
    private String type;

    public Luggage(){
    }

    public Luggage(int idLuggage,String weight,String type){
        this.idLuggage = idLuggage;
        this.weight = weight;
        this.type = type;
    }

    public int getIdLuggage() {
        return idLuggage;
    }

    public void setIdLuggage(int idLuggage) {
        this.idLuggage = idLuggage;
    }

    public String getWeight() {
        return weight;
    }

    public void setWeight(String weight) {
        this.weight = weight;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }


    @Override
    public String toString() {
        return "Luggage{" +
                "id_Luggage=" + idLuggage +
                ", weight=" + weight +
                ", type='" + type + '\'' +
                '}';
    }
}
