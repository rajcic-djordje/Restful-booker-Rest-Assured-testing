package com.rajcic.classes.response;

import com.fasterxml.jackson.annotation.JsonProperty;

public class BookingDates {

    @JsonProperty("checkin")
    private String checkin;

    @JsonProperty("checkout")
    private String checkout;


    public BookingDates(){}

    public BookingDates(String checkin, String checkout){

        this.checkin = checkin;
        this.checkout = checkout;
    }


    public String getCheckin(){
        return this.checkin;
    }

    public String getCheckout(){
        return this.checkout;
    }
}
