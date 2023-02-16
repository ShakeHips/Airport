package com.solvd.airport.service;

import com.solvd.airport.model.Booking;
import com.solvd.airport.model.Payment;

public interface PaymentService extends GenericService<Payment, Integer>{
    void updateByPaymentID(Payment payment, Integer PaymentID);
}
