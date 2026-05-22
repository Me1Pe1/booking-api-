package com.example.booking.repository;

import org.springframework.stereotype.Repository;
import com.example.booking.entity.Booking;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

@Repository
public interface BookingRepository extends JpaRepository<Booking, Long> {

    List<Booking> findByRoomId(Long roomId);
}