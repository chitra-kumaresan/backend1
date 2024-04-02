package com.example.Online_Bus_Reservation_Project.service;

import com.example.Online_Bus_Reservation_Project.dto.BookingDto;
import com.example.Online_Bus_Reservation_Project.entity.Booking;
import com.example.Online_Bus_Reservation_Project.entity.Bus;
import com.example.Online_Bus_Reservation_Project.entity.Passenger;
import com.example.Online_Bus_Reservation_Project.exception.ResourceNotFoundException;
import com.example.Online_Bus_Reservation_Project.mapper.BookingMapper;
import com.example.Online_Bus_Reservation_Project.repository.BookingRepo;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.BDDMockito.given;

@ExtendWith(MockitoExtension.class)
public class BookingServiceTests {
    @Mock
    private BookingRepo bookingRepo;
    @InjectMocks
    private  BookingServiceImpl bookingService;

    private Booking booking;
    @BeforeEach
    public void setUp(){
        booking=Booking.builder()
                .bus(new Bus())
                .passenger(new Passenger())
                .build();
    }
    @Test
    public void givenBookingList_whenGetAllBookings_thenReturnBookingList(){
       Booking booking1=Booking.builder()
                .bus(new Bus())
                .passenger(new Passenger())
                .build();
    given(bookingRepo.findAll()).willReturn(List.of(booking,booking1));
   List<BookingDto> bookings=bookingService.getAllBookings();
        assertThat(bookings).isNotNull();
        assertThat(bookings.size()).isEqualTo(2);

    }
    @Test
    public void givenBooking_whenGetBookingsById_thenReturnBooking(){

        given(bookingRepo.findById(booking.getId())).willReturn(Optional.of(booking));
        BookingDto bookings=bookingService.getBookingById(booking.getId());
        assertThat(bookings).isNotNull();


    }



    }








