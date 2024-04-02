package com.example.Online_Bus_Reservation_Project.repository;
import com.example.Online_Bus_Reservation_Project.entity.Payment;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PaymentRepo extends JpaRepository<Payment,Long> {
}
