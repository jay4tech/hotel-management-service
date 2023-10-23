package com.example.hotel.service;

import com.example.hotel.entity.RoomInventory;
import com.example.hotel.repository.RoomRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;
import java.util.Optional;

@Service
public class RoomService implements IRoomService {

    @Autowired
    RoomRepository roomRepository;


    @Override
    public RoomInventory saveRoomInventory(RoomInventory roomInventory) {
        return roomRepository.save(roomInventory);
    }

    @Override
    public RoomInventory getRoomInventory(Long id) {
        return roomRepository.findById(id).orElse(null);
    }

    @Override
    public RoomInventory getRoomInventoryAvailability(RoomInventory roomInventory) {
        List<RoomInventory> roomInventoryList = roomRepository.findAll();
        RoomInventory roomInventoryResult = null;
        roomInventoryList.removeIf(room ->
                !(Objects.equals(room.getId(), roomInventory.getId()) && room.getQuantity() > 0L)
        );
        if (!roomInventoryList.isEmpty()) {
            roomInventoryResult = roomInventoryList.get(0);
        }
        return roomInventoryResult;
    }

    @Override
    public RoomInventory updateRoomInventory(RoomInventory roomInventory) {
        Optional<RoomInventory> optionalRoomInventory = roomRepository.findById(roomInventory.getId());
        RoomInventory roomInventoryDb = null;
        if (optionalRoomInventory.isPresent()) {
            roomInventoryDb = optionalRoomInventory.get();
            roomInventoryDb.setQuantity(roomInventoryDb.getQuantity() - roomInventory.getQuantity());
            roomRepository.save(roomInventoryDb);
        }
        return roomInventoryDb;
    }
}
