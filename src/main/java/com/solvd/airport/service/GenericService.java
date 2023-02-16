package com.solvd.airport.service;

import java.util.List;

public interface GenericService<T, V> {
    boolean create(T element);

    T get(V id);

    List<T> getAll();

    void update(T element);

    boolean delete(V id);
}
