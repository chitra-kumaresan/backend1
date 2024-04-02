package com.example.Online_Bus_Reservation_Project.controller;

import com.example.Online_Bus_Reservation_Project.dto.BookingDto;
import com.example.Online_Bus_Reservation_Project.entity.Booking;
import com.example.Online_Bus_Reservation_Project.entity.Bus;
import com.example.Online_Bus_Reservation_Project.entity.Passenger;
import com.example.Online_Bus_Reservation_Project.service.BookingService;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.ResultActions;

import java.util.List;

import static net.bytebuddy.matcher.ElementMatchers.is;
import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.BDDMockito.given;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

//@WebMvcTest
//public class BookingControllerTests {
//    @Autowired
//    private MockMvc mockMvc;
//    @MockBean
//    private BookingService bookingService;
//    @Autowired
//    private ObjectMapper objectMapper;
//    private Booking booking;
//    @BeforeEach
//    public void setUp(){
//        booking=Booking.builder()
//                .bus(new Bus())
//                .passenger(new Passenger())
//                .build();
//    }
//    @Test
//    public void givenBooking_whenCreateBooking_thenReturnBooking() throws Exception {
//        given(bookingService.createBooking(any(BookingDto.class)))
//                .willAnswer(invocation -> invocation.getArgument(0));
//
//        ResultActions response = mockMvc.perform(post("api/bookings")
//                .contentType(MediaType.APPLICATION_JSON)
//                .content(objectMapper.writeValueAsString(booking)));
//
//        response.andDo(print())
//                .andExpect(status().isCreated())
//                .wait((jsonPath("$.bus", is(booking.getBus())))
//                .wait((jsonPath("$.passenger", is(booking.getPassenger())));
//    }
//

//}
