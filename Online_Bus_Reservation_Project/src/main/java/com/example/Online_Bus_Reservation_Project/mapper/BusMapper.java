package com.example.Online_Bus_Reservation_Project.mapper;
import com.example.Online_Bus_Reservation_Project.dto.BusDto;
import com.example.Online_Bus_Reservation_Project.entity.Bus;



public class BusMapper {
    public static BusDto mapToBusDto(Bus bus) {

        return new BusDto(
                bus.getId(),
                bus.getBusName(),
                bus.getBusNumber(),
                bus.getFromDeparture(),
                bus.getToDeparture(),
                bus.getTicketPrice(),
                bus.getNoOfSeats(),
                bus.getBusDate()

        );
    }
    public static Bus mapToBus(BusDto busDto) {

        return new Bus(
                busDto.getId(),
                busDto.getBusName(),
                busDto.getBusNumber(),
                busDto.getFromDeparture(),
                busDto.getToDeparture(),
                busDto.getTicketPrice(),
                busDto.getNoOfSeats(),
                busDto.getBusDate()

        );
    }

}
