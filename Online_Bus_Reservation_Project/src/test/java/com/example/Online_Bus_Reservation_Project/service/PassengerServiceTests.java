package com.example.Online_Bus_Reservation_Project.service;

import com.example.Online_Bus_Reservation_Project.dto.BookingDto;
import com.example.Online_Bus_Reservation_Project.dto.PassengerDto;
import com.example.Online_Bus_Reservation_Project.entity.Booking;
import com.example.Online_Bus_Reservation_Project.entity.Bus;
import com.example.Online_Bus_Reservation_Project.entity.Passenger;
import com.example.Online_Bus_Reservation_Project.repository.BookingRepo;
import com.example.Online_Bus_Reservation_Project.repository.PassengerRepo;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.BDDMockito.given;

    @ExtendWith(MockitoExtension.class)
    public class PassengerServiceTests  {
        @Mock
        private PassengerRepo passengerRepo;
        @InjectMocks
        private  PassengerServiceImpl passengerService;

        private Passenger passenger;
        @BeforeEach
        public void setUp(){
            passenger=Passenger.builder()
                    .fullName("chitraP")
                    .dob(LocalDate.parse("2024-05-06"))
                    .email("chitrap803@gmail.com")
                    .gender("female")
                    .phoneNumber("123456")
                    .seatNo("4")
                    .build();
        }
        @Test
        public void givenPassengerList_whenGetAllPassenger_thenReturnPassengerList(){
            Passenger passenger1=Passenger.builder()
                    .fullName("chitra")
                    .dob(LocalDate.parse("2024-05-06"))
                    .email("chitra803@gmail.com")
                    .gender("female")
                    .phoneNumber("123456")
                    .seatNo("4")
                    .build();

            given(passengerRepo.findAll()).willReturn(List.of(passenger,passenger1));
            List<PassengerDto> passengers=passengerService.getAllPassengers();
            assertThat(passengers).isNotNull();
            assertThat(passengers.size()).isEqualTo(2);

        }
        @Test
        public void givenBooking_whenGetBookingsById_thenReturnBooking(){

            given(passengerRepo.findById(passenger.getId())).willReturn(Optional.of(passenger));
            PassengerDto passengers=passengerService.getPassengerById(passenger.getId());
            assertThat(passengers).isNotNull();


        }



    }





