package com.solvd.airport.model;

import java.util.Objects;

public class Employee {
    private int idEmployee;
    private String Position;
    private String Name;
    private int airplaneId;

    public Employee(){

    }

    public Employee(int idEmployee, String Position, String Name, int airplaneId){
        this.idEmployee = idEmployee;
        this.Position = Position;
        this.Name = Name;
        this.airplaneId = airplaneId;
    }

    public int getIdEmployee() {
        return idEmployee;
    }

    public void setIdEmployee(int idEmployee) {
        this.idEmployee = idEmployee;
    }

    public String getPosition() {
        return Position;
    }

    public void setPosition(String position) {
        Position = position;
    }

    public String getName() {
        return Name;
    }

    public void setName(String name) {
        Name = name;
    }

    public int getAirplaneId() {
        return airplaneId;
    }

    public void setAirplaneId(int airplaneId) {
        this.airplaneId = airplaneId;
    }
}
