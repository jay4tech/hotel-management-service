package com.example.hotel.controller;

import com.example.hotel.entity.RoomInventory;
import com.example.hotel.service.IRoomService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("rooms")
public class RoomController {

    @Autowired
    IRoomService roomService;
    @PostMapping("/")
    public RoomInventory saveRoomInventory(@RequestBody RoomInventory roomInventory){
        return roomService.saveRoomInventory(roomInventory);
    }
    @GetMapping("/{id}")
    public RoomInventory getRoomInventory(@PathVariable Long id){
        return roomService.getRoomInventory(id);
    }

    @PostMapping("/availability")
    public RoomInventory getAvailability(@RequestBody RoomInventory roomInventory){
        return roomService.getRoomInventoryAvailability(roomInventory);
    }
    @PutMapping("/")
    public RoomInventory updateInventory(@RequestBody RoomInventory roomInventory){
        return roomService.updateRoomInventory(roomInventory);
    }
}
