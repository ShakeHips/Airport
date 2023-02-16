package com.solvd.airport.service.implementation;

import com.solvd.airport.model.Passenger;
import com.solvd.airport.dao.IPassengerDao;
import com.solvd.airport.service.PassengerService;

import java.util.List;

public class PassengerServiceimpl implements PassengerService {

    PassengerServiceimpl passengerServiceimpl;

    PassengerServiceimpl(){
        passengerServiceimpl = new PassengerServiceimpl();
    }
    @Override
    public boolean create(Passenger element) {
        return passengerServiceimpl.create(element);
    }

    @Override
    public Passenger get(Integer id) {
        return passengerServiceimpl.get(id);
    }

    @Override
    public List<Passenger> getAll() {
        return passengerServiceimpl.getAll();
    }

    @Override
    public void update(Passenger element) {
        passengerServiceimpl.update(element);
    }

    @Override
    public boolean delete(Integer id) {
        return passengerServiceimpl.delete(id);
    }

    @Override
    public void updateByPassengerID(Passenger passenger, Integer PassengerID) {
        passengerServiceimpl.updateByPassengerID(passenger, PassengerID);
    }
}
