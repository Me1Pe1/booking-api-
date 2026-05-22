package com.example.booking.repository;

import org.springframework.stereotype.Repository;
import com.example.booking.entity.Room;
import org.springframework.data.jpa.repository.JpaRepository;


@Repository
public interface RoomRepository extends JpaRepository<Room, Long> {
}
