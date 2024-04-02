package com.example.Online_Bus_Reservation_Project.mapper;
import com.example.Online_Bus_Reservation_Project.dto.PassengerDto;
import com.example.Online_Bus_Reservation_Project.entity.Passenger;

public class PassengerMapper {
    public static PassengerDto mapToPassengerDto(Passenger passenger) {

        return new PassengerDto(
                passenger.getId(),
                passenger.getFullName(),
                passenger.getDob(),
                passenger.getEmail(),
                passenger.getGender(),
                passenger.getPhoneNumber(),
                passenger.getSeatNo()



        );

    }
    public static Passenger mapToPassenger(PassengerDto passengerDto){
        return new Passenger(
                passengerDto.getId(),
                passengerDto.getFullName(),
                passengerDto.getDob(),
                passengerDto.getEmail(),

                passengerDto.getGender(),
                passengerDto.getPhoneNumber(),
                passengerDto.getSeatNo()

        );

    }
}
