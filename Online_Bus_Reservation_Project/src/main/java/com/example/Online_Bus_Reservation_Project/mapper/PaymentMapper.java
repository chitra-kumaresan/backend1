package com.example.Online_Bus_Reservation_Project.mapper;


import com.example.Online_Bus_Reservation_Project.dto.PaymentDto;

import com.example.Online_Bus_Reservation_Project.entity.Payment;

public class PaymentMapper {
    public static PaymentDto mapToPaymentDto(Payment payment) {

        return new PaymentDto(
                payment.getId(),
                payment.getCardNumber(),
                payment.getNameOnCard(),
                payment.getPrice()
        );
    }
    public static Payment mapToPayment(PaymentDto paymentDto) {

        return new Payment(
                paymentDto.getId(),
                paymentDto.getCardNumber(),
                paymentDto.getNameOnCard(),
                paymentDto.getPrice()
        );
    }
}