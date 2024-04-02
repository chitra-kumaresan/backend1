package com.example.Online_Bus_Reservation_Project.repository;

import com.example.Online_Bus_Reservation_Project.entity.Bus;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BusRepo extends JpaRepository<Bus,Long> {


}
