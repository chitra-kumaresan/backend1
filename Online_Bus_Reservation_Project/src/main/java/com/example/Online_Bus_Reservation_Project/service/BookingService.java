package com.example.Online_Bus_Reservation_Project.service;

import com.example.Online_Bus_Reservation_Project.dto.BookingDto;
import com.example.Online_Bus_Reservation_Project.dto.PassengerDto;
import com.example.Online_Bus_Reservation_Project.entity.Passenger;

import java.util.List;

public interface BookingService {
    BookingDto createBooking(BookingDto bookingsDto);
    BookingDto getBookingById(Long bookedId);
    List<BookingDto> getAllBookings();
    BookingDto updateBooking(Long bookedId, BookingDto updatedBookings);
    void deleteById(Long bookedId);

    BookingDto getByPassengerId(Long id);
    BookingDto findByEmail(String email);
}
