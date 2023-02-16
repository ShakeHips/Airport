package com.solvd.airport.service.implementation;

import com.solvd.airport.model.Booking;
import com.solvd.airport.dao.IBookingDao;
import com.solvd.airport.service.BookingService;

import java.util.List;

public class BookingServiceImpl implements BookingService {

    BookingServiceImpl bookingServiceImpl;

    BookingServiceImpl(){
        bookingServiceImpl = new BookingServiceImpl();
    }
    @Override
    public boolean create(Booking element) {
        return bookingServiceImpl.create(element);
    }

    @Override
    public Booking get(Integer id) {
        return bookingServiceImpl.get(id);
    }

    @Override
    public List<Booking> getAll() {
        return bookingServiceImpl.getAll();
    }

    @Override
    public void update(Booking element) {
        bookingServiceImpl.update(element);
    }

    @Override
    public boolean delete(Integer id) {
        return bookingServiceImpl.delete(id);
    }
}
