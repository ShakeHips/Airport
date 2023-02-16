package com.solvd.airport.model;

import java.util.Objects;

public class Payment {
    private int idPayment;
    private String ZIPcode;
    private int paymenttypeId;
    private int bookingId;

    public Payment(){

    }

    public Payment(int idPayment, String ZIPcode, int paymenttypeId, int bookingId) {
        this.idPayment = idPayment;
        this.ZIPcode = ZIPcode;
        this.paymenttypeId = paymenttypeId;
        this.bookingId = bookingId;
    }

    public int getIdPayment() {
        return idPayment;
    }

    public void setIdPayment(int idPayment) {
        this.idPayment = idPayment;
    }

    public String getZIPcode() {
        return ZIPcode;
    }

    public void setZIPcode(String ZIPcode) {
        this.ZIPcode = ZIPcode;
    }

    public int getPaymenttypeId() {
        return paymenttypeId;
    }

    public void setPaymenttypeId(int paymenttypeId) {
        this.paymenttypeId = paymenttypeId;
    }

    public int getBookingId() {
        return bookingId;
    }

    public void setBookingId(int bookingId) {
        this.bookingId = bookingId;
    }
}
