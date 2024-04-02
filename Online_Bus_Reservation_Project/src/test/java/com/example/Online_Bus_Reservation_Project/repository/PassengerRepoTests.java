package com.example.Online_Bus_Reservation_Project.repository;

import com.example.Online_Bus_Reservation_Project.entity.Bus;
import com.example.Online_Bus_Reservation_Project.entity.Passenger;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

import static org.assertj.core.api.Assertions.assertThat;


@DataJpaTest
public class PassengerRepoTests {
    @Autowired
    private PassengerRepo passengerRepo;
    private Passenger passenger;


    @BeforeEach
    public void setUp(){
        passenger=Passenger.builder()
                .fullName("chitra")
                .dob(LocalDate.ofEpochDay(2024-03-05))
                .email("chitrap803@gmail.com")
                .gender("female")
                .phoneNumber("123456")
                .seatNo("4")
                .build();
    }

    @DisplayName("Test whether the passenger get saved in DB")
    @Test
    public void givenPassenger_whenSave_thenReturnSavedPassenger(){
        Passenger savedPassenger=passengerRepo.save(passenger);
        assertThat(savedPassenger).isNotNull();
        assertThat(savedPassenger.getId()).isGreaterThan(0);


    }
    @Test
    public  void givenPassengerList_whenFindAll_thenPassengerList() {
        Passenger passenger1 = Passenger.builder()
                .fullName("chitraP")
                .dob(LocalDate.parse("2024-05-06"))
                .email("chitrap803@gmail.com")
                .gender("female")
                .phoneNumber("123456")
                .seatNo("4")
                .build();

        passengerRepo.save(passenger);
        passengerRepo.save(passenger1);

        List<Passenger> passengerList = passengerRepo.findAll();
        assertThat(passengerList).isNotNull();
        assertThat(passengerList.size()).isEqualTo(2);

    }
    @Test
    public  void givenPassengerEmail_whenFindByEmail_thenReturnPassenger(){
        passengerRepo.save(passenger);
        Passenger passengerDb=passengerRepo.findByEmail(passenger.getEmail());
        assertThat(passengerDb).isNotNull();

    }
    @Test
    public  void givenPassenger_whenUpdatePassenger_thenReturnUpdatedPassenger(){
        passengerRepo.save(passenger);
        Passenger savedPassenger=passengerRepo.findById(passenger.getId()).get();
        savedPassenger.setEmail("kumar@gmail.com");
        Passenger updatedPassenger=passengerRepo.save(savedPassenger);
        assertThat(updatedPassenger.getEmail()).isEqualTo("kumar@gmail.com");
    }
    @Test
    public  void givenPassenger_whenDelete_thenRemovePassenger(){
        passengerRepo.save(passenger);
        passengerRepo.deleteById(passenger.getId());
        Optional<Passenger> passenger1=passengerRepo.findById(passenger.getId());
        assertThat(passenger1).isEmpty();

    }



    }
