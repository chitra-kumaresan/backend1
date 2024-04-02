package com.example.Online_Bus_Reservation_Project.service;

import com.example.Online_Bus_Reservation_Project.dto.BookingDto;
import com.example.Online_Bus_Reservation_Project.dto.BusDto;
import com.example.Online_Bus_Reservation_Project.entity.Booking;
import com.example.Online_Bus_Reservation_Project.entity.Bus;
import com.example.Online_Bus_Reservation_Project.entity.Passenger;
import com.example.Online_Bus_Reservation_Project.repository.BookingRepo;
import com.example.Online_Bus_Reservation_Project.repository.BusRepo;
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
    public class BusServiceTests {
        @Mock
        private BusRepo busRepo;
        @InjectMocks
        private  BusServiceImpl busService;

        private Bus bus;
        @BeforeEach
        public void setUp(){
            bus=Bus.builder()
                    .busName("travel")
                    .busNumber("12345")
                    .fromDeparture("Eerode")
                    .toDeparture("Cchennai")
                    .Date(LocalDate.parse("2024-06-06"))
                    .ticketPrice(67L)
                    .noOfSeats(19L)
                    .build();
        }
        @Test
        public void givenBusList_whenGetAllBuss_thenReturnBusList(){
            Bus bus1=Bus.builder()
                    .busName("travels")
                    .busNumber("123456")
                    .fromDeparture("erode")
                    .toDeparture("chennai")
                    .Date(LocalDate.parse("2024-06-06"))
                    .ticketPrice(67L)
                    .noOfSeats(1L)
                    .build();

            given(busRepo.findAll()).willReturn(List.of(bus,bus1));
            List<BusDto> bus=busService.getAllBus();
            assertThat(bus).isNotNull();
            assertThat(bus.size()).isEqualTo(2);

        }
        @Test
        public void givenBus_whenGetBussById_thenReturnBus(){

            given(busRepo.findById(bus.getId())).willReturn(Optional.of(bus));
            BusDto buss=busService.getBusById(bus.getId());
            assertThat(buss).isNotNull();


        }



    }

