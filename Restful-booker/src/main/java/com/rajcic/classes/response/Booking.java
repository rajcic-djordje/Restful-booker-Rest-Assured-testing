package com.rajcic.classes.response;

import com.fasterxml.jackson.annotation.JsonProperty;


public class Booking {


    @JsonProperty("firstname")
    private String firstName;

    @JsonProperty("lastname")
    private String lastName;

    @JsonProperty("totalprice")
    private int totalPrice;

    @JsonProperty("depositpaid")
    private boolean depositPaid;

    @JsonProperty("bookingdates")
    private BookingDates bookingDates;

    @JsonProperty("additionalneeds")
    private String additionalNeeds;


    public Booking(){

    }

    public Booking(String firstName,
                   String lastName,
                   int totalPrice,
                   boolean depositPaid,
                   BookingDates bookingDates,
                   String additionalNeeds){

        this.firstName = firstName;
        this.lastName = lastName;
        this.totalPrice = totalPrice;
        this.depositPaid = depositPaid;
        this.bookingDates = bookingDates;
        this.additionalNeeds = additionalNeeds;

    }

    public String getFirstName(){
        return this.firstName;
    }

    public String getLastName(){
        return this.lastName;
    }

    public int getTotalPrice(){
        return this.totalPrice;
    }

    public boolean getDepositPaid(){
        return this.depositPaid;
    }

    public BookingDates getBookingDates(){
        return this.bookingDates;
    }

    public String getAdditionalNeeds(){
        return this.additionalNeeds;
    }
}


