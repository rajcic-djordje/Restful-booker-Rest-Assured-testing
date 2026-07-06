package com.rajcic.classes.response;

import com.fasterxml.jackson.annotation.JsonProperty;

public class BookingResponse {

    @JsonProperty("bookingid")
    private int bookingId;

    @JsonProperty("booking")
    private Booking booking;

    public int getBookingId() {
        return bookingId;
    }

    public Booking getBooking() {
        return booking;
    }
}
