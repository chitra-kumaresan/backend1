package com.example.Online_Bus_Reservation_Project.entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.fasterxml.jackson.datatype.jsr310.deser.LocalDateTimeDeserializer;
import com.fasterxml.jackson.datatype.jsr310.ser.LocalDateSerializer;
import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDate;


@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@ToString
@Builder
@Table(name="bus_routes")
public class Bus {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String busName;
    private String busNumber;
    private String fromDeparture;
    private String toDeparture;
    private Long ticketPrice;
    private Long noOfSeats;
    @JsonDeserialize(using= LocalDateTimeDeserializer.class)
    @JsonSerialize(using = LocalDateSerializer.class)

    @JsonFormat(shape = JsonFormat.Shape.STRING,pattern = "yyyy-mm-dd")
    private LocalDate busDate;


}
