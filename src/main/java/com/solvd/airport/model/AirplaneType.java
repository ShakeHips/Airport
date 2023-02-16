package com.solvd.airport.model;

import java.util.Objects;

public class AirplaneType {
    private int idAirplane;
    private String Description;
    private int airplaneId;

    AirplaneType(){

    }

    AirplaneType(int idAirplane, String Description, int airplaneId){
        this.idAirplane = idAirplane;
        this.Description = Description;
        this.airplaneId = airplaneId;
    }

    public int getIdAirplane() {
        return idAirplane;
    }

    public void setIdAirplane(int idAirplane) {
        this.idAirplane = idAirplane;
    }

    public String getDescription() {
        return Description;
    }

    public void setDescription(String description) {
        Description = description;
    }

    public int getAirplaneId() {
        return airplaneId;
    }

    public void setAirplaneId(int airplaneId) {
        this.airplaneId = airplaneId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        AirplaneType that = (AirplaneType) o;
        return idAirplane == that.idAirplane && airplaneId == that.airplaneId && Objects.equals(Description, that.Description);
    }

    @Override
    public int hashCode() {
        return Objects.hash(idAirplane, Description, airplaneId);
    }

    @Override
    public String toString() {
        return "AirplaneType{" +
                "idAirplane=" + idAirplane +
                ", Description='" + Description + '\'' +
                ", Airplane_idAirplane=" + airplaneId +
                '}';
    }
}
