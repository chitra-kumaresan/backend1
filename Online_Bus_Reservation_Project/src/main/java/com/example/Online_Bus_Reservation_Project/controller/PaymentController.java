package com.example.Online_Bus_Reservation_Project.controller;

import com.example.Online_Bus_Reservation_Project.dto.PaymentDto;
import com.example.Online_Bus_Reservation_Project.service.PaymentService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@CrossOrigin("*")
    @RestController
    @RequestMapping("/api/payments")
    @AllArgsConstructor

    public class PaymentController {
        private PaymentService paymentService;
        @PostMapping
        public ResponseEntity<PaymentDto> createPayment(@RequestBody PaymentDto paymentDto){
            PaymentDto savedPayment= paymentService.createPayment(paymentDto);
            return new ResponseEntity<>(savedPayment, HttpStatus.CREATED);
        }
        @GetMapping("{id}")
        public ResponseEntity<PaymentDto> getPayment(@PathVariable("id") Long paymentId){
            PaymentDto paymentDto=paymentService.getPaymentById(paymentId);
            return ResponseEntity.ok(paymentDto);
        }
        @GetMapping
        public ResponseEntity<List<PaymentDto>> getAllPayment(){
            List<PaymentDto> paymentDto=paymentService.getAllPayment();
            return ResponseEntity.ok(paymentDto);
        }
        @PutMapping("{id}")
        public ResponseEntity<PaymentDto> updatePayment(@PathVariable("id") Long paymentId,@RequestBody PaymentDto updatedPayment){
            PaymentDto paymentDto=paymentService.updatePayment(paymentId,updatedPayment);
            return ResponseEntity.ok(paymentDto);
        }
        @DeleteMapping("{id}")
        public ResponseEntity<String> deletePayment(@PathVariable("id") Long paymentId){
            paymentService.deleteById(paymentId);
            return ResponseEntity.ok("Payment deleted successfully");
        }

    }
