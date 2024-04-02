package com.example.Online_Bus_Reservation_Project.controller;

//import com.example.Online_Bus_Reservation_Project.config.UserInfoUserDetailsService;
//import com.example.Online_Bus_Reservation_Project.dto.AuthRequest;
import com.example.Online_Bus_Reservation_Project.dto.PassengerDto;
//import com.example.Online_Bus_Reservation_Project.entity.UserInfo;
import com.example.Online_Bus_Reservation_Project.repository.PassengerRepo;
//import com.example.Online_Bus_Reservation_Project.service.JwtService;
import com.example.Online_Bus_Reservation_Project.service.PassengerService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
//import org.springframework.security.access.prepost.PreAuthorize;
//import org.springframework.security.authentication.AuthenticationManager;
//import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
//import org.springframework.security.core.Authentication;
//import org.springframework.security.core.userdetails.UserDetails;
//import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin("*")
@RestController
@RequestMapping("/api/passengers")
@AllArgsConstructor

public class PassengerController {

    private PassengerRepo passengerRepo;
    private PassengerService service;

    @PostMapping("/savePassenger")
    public ResponseEntity<PassengerDto> createPassenger(@RequestBody PassengerDto passengerDto) {
        PassengerDto savedPassenger = service.createPassenger(passengerDto);
        return new ResponseEntity<>(savedPassenger, HttpStatus.CREATED);
    }

    @GetMapping("{id}")
//    @PreAuthorize("hasAuthority('ROLE_USER')")
    public ResponseEntity<PassengerDto> getPassenger(@PathVariable("id") Long passengerId) {
        PassengerDto passengerDto = service.getPassengerById(passengerId);
        return ResponseEntity.ok(passengerDto);
    }

    @GetMapping
//    @PreAuthorize("hasAuthority('ROLE_ADMIN')")
    public ResponseEntity<List<PassengerDto>> getAllPassenger() {
        List<PassengerDto> passengerDtos = service.getAllPassengers();
        return ResponseEntity.ok(passengerDtos);
    }

    @PutMapping("{id}")
    public ResponseEntity<PassengerDto> updatePassenger(@PathVariable("id") Long passengerId, @RequestBody PassengerDto updatedPassenger) {
        PassengerDto passengerDto = service.updatePassenger(passengerId, updatedPassenger);
        return ResponseEntity.ok(passengerDto);
    }

    @DeleteMapping("{id}")
    public ResponseEntity<String> deletePassenger(@PathVariable("id") Long passengerId) {
        service.deleteById(passengerId);
        return ResponseEntity.ok("Passenger deleted successfully");
    }

    @GetMapping("email/{email}")
   public ResponseEntity<PassengerDto> getPassengerByEmail(@PathVariable String email){
       PassengerDto passengerDto=service.findByEmail(email);

       return new ResponseEntity<PassengerDto>(passengerDto,HttpStatus.OK);
    }
}
