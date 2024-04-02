package com.example.Online_Bus_Reservation_Project.entity;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDate;
import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@ToString
//@Builder
@Table(name="bookings")

public class Booking {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;


//    @ManyToOne(targetEntity = Bus.class,cascade = CascadeType.ALL)
//    @JoinColumn(name ="bus_id",referencedColumnName = "id")

    private String busName;
    private String busNumber;
    private String fromDeparture;
    private String toDeparture;
    private Long ticketPrice;
    private LocalDate  busDate;
    private String bookingDate;
    @ManyToOne(targetEntity = Passenger.class,cascade = CascadeType.ALL)
//    @JoinColumn(name ="passenger_id",referencedColumnName = "id")
     private Passenger passenger;
    private String email;


}
