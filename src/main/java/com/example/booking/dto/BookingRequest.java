package com.example.booking.dto;

import java.time.LocalDate;

public class BookingRequest {

    public Long roomId;
    public Long userId;
    public LocalDate startDate;
    public LocalDate endDate;
}
