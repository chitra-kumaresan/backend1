package com.example.Online_Bus_Reservation_Project.repository;

import com.example.Online_Bus_Reservation_Project.dto.PassengerDto;
import com.example.Online_Bus_Reservation_Project.entity.Passenger;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;
@Repository
public interface PassengerRepo extends JpaRepository<Passenger,Long> {
    Passenger findByEmail(String emailId);


}
