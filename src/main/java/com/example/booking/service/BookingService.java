package com.example.booking.service;

import com.example.booking.entity.Booking;
import com.example.booking.entity.Room;
import com.example.booking.repository.BookingRepository;
import com.example.booking.repository.RoomRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BookingService {

    @Autowired
    private BookingRepository bookingRepository;

    @Autowired
    private RoomRepository roomRepository;

    public Booking create(Booking booking) {
        Room room = roomRepository.findById(booking.getRoom().getId())
                .orElseThrow(() -> new IllegalArgumentException("Комната не найдена"));

        List<Booking> existingBookings = bookingRepository.findByRoomId(room.getId());

        for (Booking existing : existingBookings) {
            if (existing.getStartDate().isBefore(booking.getEndDate()) &&
                    existing.getEndDate().isAfter(booking.getStartDate())) {
                throw new IllegalStateException("Room already booked");
            }
        }

        booking.setRoom(room);
        return bookingRepository.save(booking);
    }

    public Booking get(Long id) {
        return bookingRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Бронирование не найдено"));
    }

    public List<Booking> getAll() {
        return bookingRepository.findAll();
    }

    public void delete(Long id) {
        bookingRepository.deleteById(id);
    }
}