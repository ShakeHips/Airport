package com.solvd.airport.service;

import com.solvd.airport.model.Booking;
import com.solvd.airport.model.Passenger;
import com.solvd.airport.model.Payment;

public interface PassengerService extends GenericService<Passenger, Integer>{
    void updateByPassengerID(Passenger passenger, Integer PassengerID);
}
