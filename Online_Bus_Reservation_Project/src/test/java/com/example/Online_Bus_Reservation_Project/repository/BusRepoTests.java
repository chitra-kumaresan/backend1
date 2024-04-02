package com.example.Online_Bus_Reservation_Project.repository;

import com.example.Online_Bus_Reservation_Project.entity.Booking;
import com.example.Online_Bus_Reservation_Project.entity.Bus;
import com.example.Online_Bus_Reservation_Project.entity.Passenger;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import static org.assertj.core.api.Assertions.assertThat;
import java.time.LocalDate;
import java.util.List;


@DataJpaTest
    public class BusRepoTests  {
        @Autowired
        private BusRepo busRepo;
        private Bus bus;
        @BeforeEach
        public void setUp(){
            bus=Bus.builder()
                    .busName("travels")
                    .busNumber("1234")
                    .fromDeparture("erode")
                    .toDeparture("chennai")
                    .Date(LocalDate.parse("2024-05-06"))
                    .ticketPrice(678L)
                    .noOfSeats(9L)
                    .build();
        }

        @DisplayName("Test whether the BUS get saved in DB")
        @Test
        public void givenBus_whenSave_thenReturnSavedBus(){
            Bus savedBus=busRepo.save(bus);
            assertThat(savedBus).isNotNull();
            assertThat(savedBus.getId()).isGreaterThan(0);


        }


    @Test
    public  void givenBusList_whenFindAll_thenBusList(){
        Bus bus1=Bus.builder()
                .busName("travel")
                .busNumber("12345")
                .fromDeparture("Eerode")
                .toDeparture("Cchennai")
                .Date(LocalDate.parse("2024-06-06"))
                .ticketPrice(67L)
                .noOfSeats(19L)
                .build();
        busRepo.save(bus);
        busRepo.save(bus1);

        List<Bus> busList=busRepo.findAll();
        assertThat(busList).isNotNull();
        assertThat(busList.size()).isEqualTo(2);

    }



}

