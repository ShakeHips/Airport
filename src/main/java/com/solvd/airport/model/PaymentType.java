package com.solvd.airport.model;

import java.util.Objects;

public class PaymentType {
    private int idPaymentType;
    private String Paymentinfo;
    private int passengerdetailsId;

    public PaymentType(){

    }

    public PaymentType(int idPaymentType, String paymentinfo, int passengerdetailsId) {
        this.idPaymentType = idPaymentType;
        Paymentinfo = paymentinfo;
        this.passengerdetailsId = passengerdetailsId;
    }

    public int getIdPaymentType() {
        return idPaymentType;
    }

    public void setIdPaymentType(int idPaymentType) {
        this.idPaymentType = idPaymentType;
    }

    public String getPaymentinfo() {
        return Paymentinfo;
    }

    public void setPaymentinfo(String paymentinfo) {
        Paymentinfo = paymentinfo;
    }

    public int getPassengerdetailsId() {
        return passengerdetailsId;
    }

    public void setPassengerdetailsId(int passengerdetailsId) {
        this.passengerdetailsId = passengerdetailsId;
    }
}
