package com.example.hotel.service;

import com.example.hotel.entity.RoomInventory;

public interface IRoomService {
    RoomInventory saveRoomInventory(RoomInventory roomInventory);

    RoomInventory getRoomInventory(Long id);

    RoomInventory getRoomInventoryAvailability(RoomInventory roomInventory);

    RoomInventory updateRoomInventory(RoomInventory roomInventory);
}
