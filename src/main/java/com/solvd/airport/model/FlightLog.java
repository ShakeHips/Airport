package com.solvd.airport.model;

public class FlightLog {
    private int idFlightlog;
    private String flightTime;
    private String WeatherInfo;

    public FlightLog(){

    }

    public FlightLog(int idFlightlog, String flightTime, String WeatherInfo){
        this.idFlightlog = idFlightlog;
        this.flightTime = flightTime;
        this.WeatherInfo = WeatherInfo;
    }

    public int getIdFlightlog() {
        return idFlightlog;
    }

    public void setIdFlightlog(int idFlightlog) {
        this.idFlightlog = idFlightlog;
    }

    public String getFlightTime() {
        return flightTime;
    }

    public void setFlightTime(String flightTime) {
        this.flightTime = flightTime;
    }

    public String getWeatherInfo() {
        return WeatherInfo;
    }

    public void setWeatherInfo(String weatherInfo) {
        WeatherInfo = weatherInfo;
    }
}
