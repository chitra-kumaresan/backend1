package com.example.Online_Bus_Reservation_Project.service;

import com.example.Online_Bus_Reservation_Project.dto.BusDto;
import com.example.Online_Bus_Reservation_Project.entity.Bus;

import java.util.List;

public interface BusService {
    BusDto createBus(BusDto busDto);
    List<BusDto> getAllBus();
    BusDto getBusById(Long busId);
    BusDto updateBus(Long busId,BusDto updatedBus);
    void deleteBusById(Long busId);

}
