package com.example.Online_Bus_Reservation_Project.dto;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.format.annotation.DateTimeFormat;

import java.sql.Date;
import java.time.LocalDate;


@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor

public class PassengerDto {

    private Long id;
    private String fullName;
    private LocalDate dob;
    private String email;
    private String gender;
    private String phoneNumber;
    private String seatNo;



}

