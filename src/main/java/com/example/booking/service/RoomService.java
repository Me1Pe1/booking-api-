package com.example.booking.service;

import com.example.booking.entity.Room;
import com.example.booking.repository.RoomRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class RoomService {

    private final RoomRepository roomRepository;

    public Room create(Room room) {
        return roomRepository.save(room);
    }

    public List<Room> getAll() {
        return roomRepository.findAll();
    }

    public void delete(Long id) {
        roomRepository.deleteById(id);
    }
}
