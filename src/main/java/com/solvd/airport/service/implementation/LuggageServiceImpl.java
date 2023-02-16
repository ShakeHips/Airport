package com.solvd.airport.service.implementation;

import com.solvd.airport.model.Luggage;
import com.solvd.airport.service.LuggageService;

import java.util.List;

public class LuggageServiceImpl implements LuggageService {
    LuggageServiceImpl luggageServiceImpl;

    LuggageServiceImpl(){
        luggageServiceImpl = new LuggageServiceImpl();
    }
    @Override
    public boolean create(Luggage element) {
        return luggageServiceImpl.create(element);
    }

    @Override
    public Luggage get(Integer id) {
        return luggageServiceImpl.get(id);
    }

    @Override
    public List<Luggage> getAll() {
        return luggageServiceImpl.getAll();
    }

    @Override
    public void update(Luggage element) {
    luggageServiceImpl.update(element);
    }

    @Override
    public boolean delete(Integer id) {
        return luggageServiceImpl.delete(id);
    }
}
