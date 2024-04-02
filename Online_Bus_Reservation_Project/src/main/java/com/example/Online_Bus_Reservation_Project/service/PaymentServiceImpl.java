package com.example.Online_Bus_Reservation_Project.service;

import com.example.Online_Bus_Reservation_Project.dto.PaymentDto;
import com.example.Online_Bus_Reservation_Project.entity.Payment;
import com.example.Online_Bus_Reservation_Project.exception.ResourceNotFoundException;
import com.example.Online_Bus_Reservation_Project.mapper.PaymentMapper;
import com.example.Online_Bus_Reservation_Project.repository.PaymentRepo;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class PaymentServiceImpl implements PaymentService{
    private PaymentRepo paymentRepo;
    @Override
    public PaymentDto createPayment(PaymentDto paymentDto) {
        Payment payment=PaymentMapper.mapToPayment(paymentDto);
        Payment savedPayment =paymentRepo.save(payment);
        return PaymentMapper.mapToPaymentDto(savedPayment);
    }

    @Override
    public PaymentDto getPaymentById(Long paymentId) {
        Payment payment=paymentRepo.findById(paymentId)
                .orElseThrow(()->new ResourceNotFoundException("Payment is not done by this id"));

        return PaymentMapper.mapToPaymentDto(payment);
    }

    @Override
    public List<PaymentDto> getAllPayment() {
        List<Payment> paymentList=paymentRepo.findAll();
        return paymentList.stream().map(PaymentMapper::mapToPaymentDto).collect(Collectors.toList());
    }

    @Override
    public PaymentDto updatePayment(Long paymentId, PaymentDto updatedPayment) {
        Payment payment=paymentRepo.findById(paymentId)
                .orElseThrow(()->new ResourceNotFoundException("Payment is not done by this id"));
        payment.setCardNumber(updatedPayment.getCardNumber());
        payment.setNameOnCard(updatedPayment.getNameOnCard());
        payment.setPrice(updatedPayment.getPrice());
       Payment updatedExistPayment= paymentRepo.save(payment);
        return PaymentMapper.mapToPaymentDto(updatedExistPayment);
    }

    @Override
    public void deleteById(Long paymentId) {
        paymentRepo.findById(paymentId)
                .orElseThrow(()->new ResourceNotFoundException("Payment is not done by this id"));
        paymentRepo.deleteById(paymentId);

    }
}
