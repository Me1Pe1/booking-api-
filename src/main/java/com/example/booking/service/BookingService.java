package com.example.booking.service;

import com.example.booking.entity.Booking;
import com.example.booking.repository.BookingRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BookingService {

    private final BookingRepository bookingRepository;

    public BookingService(BookingRepository bookingRepository) {
        this.bookingRepository = bookingRepository;
    }

    public Booking create(Booking booking) {

        List<Booking> existing = bookingRepository.findByRoomId(booking.getRoom().getId());

        boolean conflict = existing.stream().anyMatch(b ->
                !(booking.getEndDate().isBefore(b.getStartDate()) ||
                        booking.getStartDate().isAfter(b.getEndDate()))
        );

        if (conflict) {
            throw new RuntimeException("Room is already booked for selected dates");
        }

        return bookingRepository.save(booking);
    }

    public Booking get(Long id) {
        return bookingRepository.findById(id).orElseThrow();
    }

    public List<Booking> getAll() {
        return bookingRepository.findAll();
    }
}