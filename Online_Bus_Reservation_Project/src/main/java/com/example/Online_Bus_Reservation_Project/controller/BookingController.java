package com.example.Online_Bus_Reservation_Project.controller;

//import com.example.Online_Bus_Reservation_Project.dto.AuthRequest;
import com.example.Online_Bus_Reservation_Project.dto.BookingDto;
import com.example.Online_Bus_Reservation_Project.dto.PassengerDto;
import com.example.Online_Bus_Reservation_Project.repository.BookingRepo;
import com.example.Online_Bus_Reservation_Project.service.BookingService;
//import com.example.Online_Bus_Reservation_Project.service.JwtService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@CrossOrigin("*")
@RestController
@RequestMapping("/api/bookings")
@AllArgsConstructor
public class BookingController {
    private BookingService bookingService;
    private BookingRepo bookingRepo;
    @PostMapping("/saveBooking")
    public ResponseEntity<BookingDto> createBooking(@RequestBody BookingDto bookingDto){
        BookingDto savedBooking= bookingService.createBooking(bookingDto);
        return new ResponseEntity<>(savedBooking, HttpStatus.CREATED);
    }
    @GetMapping("{id}")
    public ResponseEntity<BookingDto> getBooking(@PathVariable("id") Long bookingId){
        BookingDto bookingDto=bookingService.getBookingById(bookingId);
        return ResponseEntity.ok(bookingDto);
    }
    @GetMapping("email/{email}")
    public ResponseEntity<BookingDto> getBookingByEmail(@PathVariable String email){
        BookingDto bookingDto=bookingService.findByEmail(email);

        return new ResponseEntity<BookingDto>(bookingDto,HttpStatus.OK);
    }
    @GetMapping
    public ResponseEntity<List<BookingDto>> getAllBooking(){
        List<BookingDto> bookingDtos=bookingService.getAllBookings();
        return ResponseEntity.ok(bookingDtos);
    }
    @PutMapping("{id}")
    public ResponseEntity<BookingDto> updateBooking(@PathVariable("id") Long bookingId,@RequestBody BookingDto updatedBooking){
        BookingDto bookingDto=bookingService.updateBooking(bookingId,updatedBooking);
        return ResponseEntity.ok(bookingDto);
    }
    @DeleteMapping("{id}")
    public ResponseEntity<String> deleteBooking(@PathVariable("id") Long bookingId){
        bookingService.deleteById(bookingId);
        return ResponseEntity.ok("Booking deleted successfully");
    }
    //GET MAPPING BY GIVING PASSENGER ID
    @GetMapping("id/{id}")
    public ResponseEntity<BookingDto> getBookingsById(@PathVariable Long id){
        BookingDto bookingDto=bookingService.getByPassengerId(id);

        return new ResponseEntity<BookingDto>(bookingDto,HttpStatus.OK);
    }



}
