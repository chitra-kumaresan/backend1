package com.example.Online_Bus_Reservation_Project.service;

import com.example.Online_Bus_Reservation_Project.dto.BusDto;
import com.example.Online_Bus_Reservation_Project.entity.Bus;
import com.example.Online_Bus_Reservation_Project.exception.ResourceNotFoundException;
import com.example.Online_Bus_Reservation_Project.mapper.BusMapper;
import com.example.Online_Bus_Reservation_Project.repository.BusRepo;
import com.example.Online_Bus_Reservation_Project.repository.UserRepo;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class BusServiceImpl implements BusService{
    private BusRepo busRepo;
    private UserRepo userRepo;
    @Override
    public BusDto createBus(BusDto busDto) {
        Bus bus=BusMapper.mapToBus(busDto);
        Bus savedBus=busRepo.save(bus);
        return BusMapper.mapToBusDto(savedBus);
    }

    @Override
    public List<BusDto> getAllBus() {
        List<Bus> busList=busRepo.findAll();
        return busList.stream().map(BusMapper::mapToBusDto).collect(Collectors.toList());
    }

    @Override
    public BusDto getBusById(Long busId) {
        Bus bus=busRepo.findById(busId)
                .orElseThrow(()->new ResourceNotFoundException("Bus doesn't exist"));
        return BusMapper.mapToBusDto(bus);
    }

    @Override
    public BusDto updateBus(Long busId, BusDto updatedBus) {
        Bus bus=busRepo.findById(busId)
                .orElseThrow(()->new ResourceNotFoundException("Bus doesn't exist"));
        bus.setBusName(updatedBus.getBusName());
        bus.setBusNumber(updatedBus.getBusNumber());
        bus.setFromDeparture(updatedBus.getFromDeparture());
        bus.setToDeparture(updatedBus.getToDeparture());
        bus.setTicketPrice(updatedBus.getTicketPrice());
        bus.setNoOfSeats(updatedBus.getNoOfSeats());
        bus.setBusDate(updatedBus.getBusDate());
        Bus bus1=busRepo.save(bus);
        return BusMapper.mapToBusDto(bus1);
    }

    @Override
    public void deleteBusById(Long busId) {
        busRepo.findById(busId)
                .orElseThrow(()->new ResourceNotFoundException("Bus doesn't exist"));
        busRepo.deleteById(busId);

    }


}
