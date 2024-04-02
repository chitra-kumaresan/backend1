package com.example.Online_Bus_Reservation_Project.service;

import com.example.Online_Bus_Reservation_Project.dto.BookingDto;
import com.example.Online_Bus_Reservation_Project.dto.PassengerDto;
import com.example.Online_Bus_Reservation_Project.entity.Booking;
import com.example.Online_Bus_Reservation_Project.entity.Passenger;
import com.example.Online_Bus_Reservation_Project.exception.ResourceNotFoundException;
import com.example.Online_Bus_Reservation_Project.mapper.BookingMapper;
import com.example.Online_Bus_Reservation_Project.mapper.PassengerMapper;
import com.example.Online_Bus_Reservation_Project.repository.BookingRepo;
import com.example.Online_Bus_Reservation_Project.repository.PassengerRepo;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;


@Service
@AllArgsConstructor
public class BookingServiceImpl implements BookingService{
    private BookingRepo bookingRepo;
    private PassengerRepo passengerRepo;
    @Override
    public BookingDto createBooking(BookingDto bookingsDto) {
       Booking booking= BookingMapper.mapToBookings(bookingsDto);
        // Save the booking
        Booking savedBooking   = bookingRepo.save(booking);

        return BookingMapper.mapToBookingsDto(savedBooking);
    }

    @Override
    public BookingDto getBookingById(Long bookedId) {
       Booking booking=bookingRepo.findById(bookedId)
                .orElseThrow(()->new ResourceNotFoundException("Bookings doesn't exist"));

        return BookingMapper.mapToBookingsDto(booking);
    }

    @Override
    public List<BookingDto> getAllBookings() {
        List<Booking>bookings=bookingRepo.findAll();
        return bookings.stream()
                .map(booking -> BookingMapper.mapToBookingsDto(booking)).collect(Collectors.toList());
    }

    @Override
    public BookingDto updateBooking(Long bookedId, BookingDto updatedBookings) {
       Booking booking= bookingRepo.findById(bookedId)
                .orElseThrow(()->new ResourceNotFoundException("Bookings doesn't exist"));
       booking.setBusName(updatedBookings.getBusName());
       booking.setBusNumber(updatedBookings.getBusNumber());
       booking.setFromDeparture(updatedBookings.getFromDeparture());
       booking.setToDeparture(updatedBookings.getToDeparture());
       booking.setTicketPrice(updatedBookings.getTicketPrice());
       booking.setBusDate(updatedBookings.getBusDate());
       booking.setBookingDate(updatedBookings.getBookingDate());
       booking.setPassenger(updatedBookings.getPassenger());
       booking.setEmail(updatedBookings.getEmail());

        Booking updateExistBooking=bookingRepo.save(booking);
        return BookingMapper.mapToBookingsDto(updateExistBooking);
    }

    @Override
    public void deleteById(Long bookedId) {
        bookingRepo.findById(bookedId)
                 .orElseThrow(()->new ResourceNotFoundException("Bookings doesn't exist"));
        bookingRepo.deleteById(bookedId);

    }

    @Override
    public BookingDto getByPassengerId(Long id) {
            Booking booking=bookingRepo.findByPassengerId(id);

            return BookingMapper.mapToBookingsDto(booking);
    }

    @Override
    public BookingDto findByEmail(String email) {
            Booking booking=bookingRepo.findByEmail(email);
            return BookingMapper.mapToBookingsDto(booking);

    }
}
