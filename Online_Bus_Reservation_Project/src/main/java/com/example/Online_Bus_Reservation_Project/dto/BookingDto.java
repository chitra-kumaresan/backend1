package com.example.Online_Bus_Reservation_Project.dto;

import com.example.Online_Bus_Reservation_Project.entity.Bus;
import com.example.Online_Bus_Reservation_Project.entity.Passenger;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor


public class BookingDto {

    private Long id;
    private String busName;
    private String busNumber;
    private String fromDeparture;
    private String toDeparture;
    private Long ticketPrice;
    private LocalDate busDate;
    private String bookingDate;
    private Passenger passenger;
    private String email;
}

