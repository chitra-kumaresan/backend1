package com.example.Online_Bus_Reservation_Project.service;

import com.example.Online_Bus_Reservation_Project.dto.PaymentDto;

import java.util.List;

public interface PaymentService {
    PaymentDto createPayment(PaymentDto paymentDto);
    PaymentDto getPaymentById(Long paymentId);
     List<PaymentDto> getAllPayment();
     PaymentDto updatePayment(Long paymentId,PaymentDto updatedPayment);
     void  deleteById(Long paymentId);

}
