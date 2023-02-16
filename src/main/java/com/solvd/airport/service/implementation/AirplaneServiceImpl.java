package com.solvd.airport.service.implementation;

import com.solvd.airport.model.Airplane;
import com.solvd.airport.dao.IAirplaneDao;
import com.solvd.airport.service.AirplaneService;

import java.util.List;

public class AirplaneServiceImpl implements AirplaneService {

    AirplaneServiceImpl airplaneServiceImpl;

    public AirplaneServiceImpl(){
        airplaneServiceImpl = new AirplaneServiceImpl();
    }

    @Override
    public boolean create(Airplane element) {
        return airplaneServiceImpl.create(element);
    }

    @Override
    public Airplane get(Integer id) {
        return airplaneServiceImpl.get(id);
    }

    @Override
    public List<Airplane> getAll() {
        return airplaneServiceImpl.getAll();
    }

    @Override
    public void update(Airplane element) {
        airplaneServiceImpl.update(element);
    }

    @Override
    public boolean delete(Integer id) {
        return airplaneServiceImpl.delete(id);
    }
}
