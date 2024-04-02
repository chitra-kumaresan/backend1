package com.example.Online_Bus_Reservation_Project.mapper;

import com.example.Online_Bus_Reservation_Project.dto.BookingDto;
import com.example.Online_Bus_Reservation_Project.entity.Booking;
import com.example.Online_Bus_Reservation_Project.entity.Bus;

import java.time.LocalDate;

public class BookingMapper {
    public static BookingDto mapToBookingsDto (Booking bookings) {

        return new BookingDto(
                bookings.getId(),
               bookings.getBusName(),
               bookings.getBusNumber(),
               bookings.getFromDeparture(),
               bookings.getToDeparture(),
               bookings.getTicketPrice(),
               bookings.getBusDate(),
                bookings.getBookingDate(),
                bookings.getPassenger(),
                bookings.getEmail()
        );
    }
    public static Booking mapToBookings (BookingDto bookingsDto) {

        return new Booking(
                bookingsDto.getId(),
                bookingsDto.getBusName(),
                bookingsDto.getBusNumber(),
                bookingsDto.getFromDeparture(),
                bookingsDto.getToDeparture(),
                bookingsDto.getTicketPrice(),
                bookingsDto.getBusDate(),
                bookingsDto.getBookingDate(),
                bookingsDto.getPassenger(),
                bookingsDto.getEmail()
        );
    }


}
