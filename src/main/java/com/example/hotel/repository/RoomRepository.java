package com.example.hotel.repository;

import com.example.hotel.entity.RoomInventory;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RoomRepository extends JpaRepository<RoomInventory, Long> {
}
