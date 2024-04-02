package com.example.Online_Bus_Reservation_Project.dto;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.sql.Date;
import java.time.LocalDate;


@Data
    @AllArgsConstructor
    @NoArgsConstructor

    public class BusDto {

        private Long id;
        private String busName;
        private String busNumber;
        private String fromDeparture;
        private String toDeparture;
        private Long ticketPrice;
        private Long noOfSeats;
        private LocalDate busDate;


    }

