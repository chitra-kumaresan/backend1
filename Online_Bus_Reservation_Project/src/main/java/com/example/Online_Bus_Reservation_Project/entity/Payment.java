package com.example.Online_Bus_Reservation_Project.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.format.annotation.DateTimeFormat;
import java.sql.Date;
@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Builder
@Table(name="payment")
public class Payment {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String cardNumber;
    private String nameOnCard;
    private Long price;
}
