package com.example.Online_Bus_Reservation_Project.dto;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.sql.Date;

    @Data
    @AllArgsConstructor
    @NoArgsConstructor

    public class PaymentDto {

        private Long id;
        private String cardNumber;
        private String nameOnCard;
        private Long price;
    }


