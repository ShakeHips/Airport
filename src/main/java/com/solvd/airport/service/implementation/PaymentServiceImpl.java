package com.solvd.airport.service.implementation;

import com.solvd.airport.model.Payment;
import com.solvd.airport.dao.IPaymentDao;
import com.solvd.airport.service.PaymentService;

import java.util.List;

public class PaymentServiceImpl implements PaymentService {
    private PaymentServiceImpl paymentServiceImpl;

    public PaymentServiceImpl(){
        paymentServiceImpl = new PaymentServiceImpl();
    }
    @Override
    public boolean create(Payment element) {
        return paymentServiceImpl.create(element);
    }

    @Override
    public Payment get(Integer id) {
        return paymentServiceImpl.get(id);
    }

    @Override
    public List<Payment> getAll() {
        return paymentServiceImpl.getAll();
    }

    @Override
    public void update(Payment element) {
        paymentServiceImpl.update(element);
    }

    @Override
    public boolean delete(Integer id) {
        return paymentServiceImpl.delete(id);
    }

    @Override
    public void updateByPaymentID(Payment payment, Integer PaymentID) {
        paymentServiceImpl.updateByPaymentID(payment, PaymentID);
    }
}
