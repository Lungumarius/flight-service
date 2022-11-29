package com.example.flightservice.controller;

import com.example.flightservice.model.Flight;
import com.example.flightservice.service.FlightService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/flight")
public class FlightController {
    @Autowired
    FlightService flightService;


    @GetMapping("/get/{id}")
    public Flight getFlight( @PathVariable Long id){
        return flightService.getFlightById(id);
    }
    @GetMapping("/find/")
    public Flight get( @PathVariable Long id){
        return flightService.getFlightById(id);
    }
    @GetMapping("/find/origin={origin}&destination={destination}")
    public List<Flight> findFlight( @PathVariable String origin, @PathVariable String destination){
        return flightService.getFlightsByOriginAndDestination(origin,destination);
    }
//    @GetMapping("/find/origin={origin}&destination={destination}&airline={airline}" +
//            "&scales={scales}&allowLuggage={allowLuggage}&schedule={schedule}")
//    public List<Flight> findFlightByFilters( @PathVariable String origin, @PathVariable String destination,
//                                             @PathVariable String airline,
//                                             @PathVariable Integer scales, @PathVariable Boolean allowLuggage,
//                                             @PathVariable Integer schedule){
//        // Schedule is the hour from when the flights wanted should depart
//        return flightService.getFlightsByFilters(origin,destination,airline,scales,allowLuggage,schedule);
//    }

}
