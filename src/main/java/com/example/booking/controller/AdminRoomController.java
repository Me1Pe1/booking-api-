package com.example.booking.controller;

import com.example.booking.entity.Room;
import com.example.booking.service.RoomService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/admin/rooms")
@RequiredArgsConstructor
public class AdminRoomController {

    private final RoomService roomService;

    @PostMapping
    public Room create(@RequestBody Room room) {
        return roomService.create(room);
    }

    @GetMapping
    public List<Room> getAll() {
        return roomService.getAll();
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) {
        roomService.delete(id);
    }
}