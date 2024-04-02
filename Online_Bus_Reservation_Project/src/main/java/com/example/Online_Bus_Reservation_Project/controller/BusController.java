package com.example.Online_Bus_Reservation_Project.controller;

import com.example.Online_Bus_Reservation_Project.dto.BusDto;
import com.example.Online_Bus_Reservation_Project.entity.User;
import com.example.Online_Bus_Reservation_Project.service.BusService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
    @CrossOrigin("*")
    @RestController
    @RequestMapping("/api/buses")
    @AllArgsConstructor
    public class BusController {
        private BusService busService;

        @PostMapping("/saveBus")
        public ResponseEntity<BusDto> createBus(@RequestBody BusDto busDto) {
            BusDto savedBus = busService.createBus(busDto);
            return new ResponseEntity<>(savedBus, HttpStatus.CREATED);
        }

        @GetMapping("{id}")
        public ResponseEntity<BusDto> getBus(@PathVariable("id") Long busId) {
            BusDto busDto = busService.getBusById(busId);
            return ResponseEntity.ok(busDto);
        }

        @GetMapping
        public ResponseEntity<List<BusDto>> getAllBus() {
            List<BusDto> busDtos = busService.getAllBus();
            return ResponseEntity.ok(busDtos);
        }

        @PutMapping("{id}")
        public ResponseEntity<BusDto> updateBus(@PathVariable("id") Long busId, @RequestBody BusDto updatedBus) {
            BusDto busDto = busService.updateBus(busId, updatedBus);
            return ResponseEntity.ok(busDto);
        }

        @DeleteMapping("{id}")
        public ResponseEntity<String> deleteBus(@PathVariable("id") Long busId) {
            busService.deleteBusById(busId);
            return ResponseEntity.ok("Bus deleted successfully");
        }

    }



