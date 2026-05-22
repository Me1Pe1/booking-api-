package com.example.booking.controller;

import com.example.booking.entity.Booking;
import com.example.booking.service.BookingService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/bookings")
public class BookingController {

    private final BookingService bookingService;

    public BookingController(BookingService bookingService) {
        this.bookingService = bookingService;
    }

    @PostMapping
    public Booking create(@RequestBody Booking booking) {
        return bookingService.create(booking);
    }

    @GetMapping("/{id}")
    public Booking get(@PathVariable Long id) {
        return bookingService.get(id);
    }

    @GetMapping
    public List<Booking> getAll() {
        return bookingService.getAll();
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) {
        bookingService.delete(id);
    }
}