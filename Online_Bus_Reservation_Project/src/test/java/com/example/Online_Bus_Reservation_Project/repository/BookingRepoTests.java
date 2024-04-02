package com.example.Online_Bus_Reservation_Project.repository;

import com.example.Online_Bus_Reservation_Project.entity.Booking;
import com.example.Online_Bus_Reservation_Project.entity.Bus;
import com.example.Online_Bus_Reservation_Project.entity.Passenger;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;


    @DataJpaTest
    public class  BookingRepoTests {
        @Autowired
        private BookingRepo bookingRepo;
        private Booking booking;


        @BeforeEach
        public void setUp(){
            booking=Booking.builder()
                    .bus(new Bus())
                    .passenger(new Passenger())
                    .build();
        }

        @DisplayName("Test whether the Booking get saved in DB")
        @Test
        public void givenBooking_whenSave_thenReturnSavedBooking(){
            Booking savedBooking=bookingRepo.save(booking);
            assertThat(savedBooking).isNotNull();
            assertThat(savedBooking.getId()).isGreaterThan(0);


        }

        @Test
        public  void givenBookingList_whenFindAll_thenBookingList(){
            Booking booking1=Booking.builder()
                    .bus(new Bus())
                    .passenger(new Passenger())
                    .build();
            bookingRepo.save(booking);
            bookingRepo.save(booking1);

            List<Booking> bookingList=bookingRepo.findAll();
            assertThat(bookingList).isNotNull();
            assertThat(bookingList.size()).isEqualTo(2);

        }


}
