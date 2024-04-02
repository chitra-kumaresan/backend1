package com.example.Online_Bus_Reservation_Project.service;

import com.example.Online_Bus_Reservation_Project.dto.PassengerDto;
//import com.example.Online_Bus_Reservation_Project.entity.UserInfo;

import java.util.List;
import java.util.Optional;

public interface PassengerService {
//    UserInfo addUser(UserInfo userInfo);
    PassengerDto createPassenger(PassengerDto passengerDto);
    PassengerDto getPassengerById(Long passengerId);
    List<PassengerDto> getAllPassengers();
    PassengerDto updatePassenger(Long passengerId,PassengerDto updatedPassenger);
    void deleteById(Long passengerId);
    PassengerDto findByEmail(String email);

//    void delete(int userId);
//    UserInfo getUserById(int userId);
//    List<UserInfo> getAllUser();
//
//    UserInfo updateUser(int userId,UserInfo userInfo);
}
