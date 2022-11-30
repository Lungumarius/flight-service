package com.example.flightservice;

import com.example.flightservice.model.Flight;
import com.example.flightservice.service.FlightService;
import org.junit.Assert;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.time.LocalDateTime;
import java.time.Month;
import java.util.ArrayList;
import java.util.List;

@SpringBootTest
public class Flight_service_tests {

    @Autowired
    FlightService flightService;
    Flight flight = new Flight(1L,"123AB",Flight.Origin.Spain, Flight.Destination.Romania,
            "WizzAir", LocalDateTime.of(2022, Month.NOVEMBER, 22, 9,0),
            "2h 30m", true,3,306L);
    Flight flight2 = new Flight(2L,"125AB",Flight.Origin.Romania, Flight.Destination.Spain,
            "BlueAir", LocalDateTime.of(2022, Month.NOVEMBER, 23, 1,0),
            "4h 30m", false,1,326L);
    List<Flight> list = new ArrayList<>();


    @Test
    void getFlightByIdTest()  {

        Assert.assertEquals(flight, flightService.getFlightById(1L));
    }
    @Test
    void getFlightsByOriginDestinationTest(){
        list.add(flight);
        Assert.assertEquals(flightService.getFlightsByOriginDestination(flight.getOrigin().toString(), flight.getDestination().toString(),
                flight.getDateTimeDeparture().getDayOfMonth(), flight.getDateTimeDeparture().getMonth().toString(), flight.getDateTimeDeparture().getYear()),list);
    }
}
