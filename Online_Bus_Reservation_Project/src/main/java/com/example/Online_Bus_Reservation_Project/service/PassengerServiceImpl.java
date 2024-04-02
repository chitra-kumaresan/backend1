package com.example.Online_Bus_Reservation_Project.service;

import com.example.Online_Bus_Reservation_Project.dto.PassengerDto;
import com.example.Online_Bus_Reservation_Project.entity.Passenger;
//import com.example.Online_Bus_Reservation_Project.entity.UserInfo;
import com.example.Online_Bus_Reservation_Project.exception.ResourceNotFoundException;
import com.example.Online_Bus_Reservation_Project.mapper.PassengerMapper;
import com.example.Online_Bus_Reservation_Project.repository.PassengerRepo;
import lombok.AllArgsConstructor;
//import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class PassengerServiceImpl implements PassengerService {
//    private UserInfoRepository repository;
    private PassengerRepo passengerRepo;
//    private PasswordEncoder passwordEncoder;

    @Override
    public PassengerDto createPassenger(PassengerDto passengerDto) {
       Passenger passenger= PassengerMapper.mapToPassenger(passengerDto);
       Passenger savedPassenger= passengerRepo.save(passenger);
        return PassengerMapper.mapToPassengerDto(savedPassenger);
    }
//    public UserInfo addUser(UserInfo userInfo) {
////        userInfo.setPassword(passwordEncoder.encode(userInfo.getPassword()));
//        repository.save(userInfo);
//        return userInfo;
//    }

    @Override
    public PassengerDto getPassengerById(Long passengerId) {
       Passenger passenger= passengerRepo.findById(passengerId)
               .orElseThrow(()->new ResourceNotFoundException("Passenger doesn't exist"));
        return PassengerMapper.mapToPassengerDto(passenger);
    }

    @Override
    public List<PassengerDto> getAllPassengers() {
       List<Passenger> passengerList= passengerRepo.findAll();
        return passengerList.stream()
                .map(passenger -> PassengerMapper.mapToPassengerDto(passenger)).collect(Collectors.toList());
    }

    @Override
    public PassengerDto updatePassenger(Long passengerId, PassengerDto updatedPassenger) {
        Passenger passenger=passengerRepo.findById(passengerId)
                .orElseThrow(()->new ResourceNotFoundException("Passenger doesnt exist"));
        passenger.setFullName(updatedPassenger.getFullName());
        passenger.setEmail(updatedPassenger.getEmail());
        passenger.setDob(updatedPassenger.getDob());
        passenger.setGender(updatedPassenger.getGender());
        passenger.setSeatNo(updatedPassenger.getSeatNo());
        passenger.setPhoneNumber(updatedPassenger.getPhoneNumber());
        Passenger updateExistPassenger=passengerRepo.save(passenger);
        return PassengerMapper.mapToPassengerDto(updateExistPassenger);
    }

    @Override
    public void deleteById(Long passengerId) {
       Passenger passenger= passengerRepo.findById(passengerId)
               .orElseThrow(()->new ResourceNotFoundException("Passenger doesnt exist"));
       passengerRepo.deleteById(passengerId);


    }

    @Override
    public PassengerDto findByEmail(String email) {
        Passenger passenger=passengerRepo.findByEmail(email);
        return PassengerMapper.mapToPassengerDto(passenger);
    }

//    @Override
//    public void delete(int userId) {
//        repository.deleteById(userId);
//    }

//    @Override
//    public UserInfo getUserById(int userId) {
//        UserInfo user= repository.findById(userId);
////                 .orElseThrow(()->new ResourceNotFoundException("User doesn't exist"));
//        return user;
//
//    }

//    @Override
//    public List<UserInfo> getAllUser() {
//        List<UserInfo> userInfos=repository.findAll();
//        return userInfos;
//    }
//
//    @Override
//    public UserInfo updateUser(int userId, UserInfo userInfo) {
//        UserInfo userInfo1=repository.findById(userId);
////                .orElseThrow(()->new ResourceNotFoundException("User doesn't exist"));
//        userInfo1.setName(userInfo.getName());
//        userInfo1.setPassword(userInfo.getPassword());
//        userInfo1.setEmail(userInfo.getEmail());
//        userInfo1.setRoles(userInfo.getRoles());
//       UserInfo savedUser= repository.save(userInfo1);
//        return  savedUser;
//    }

}
