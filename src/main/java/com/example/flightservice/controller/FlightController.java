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
//    @GetMapping("/find/")
//    public Flight get( @PathVariable Long id){
//        return flightService.getFlightById(id);
//    }

    //Optional parameters for
    @GetMapping("/find/origin={origin}&destination={destination}&day={day}&month={month}&year={year}")
    public List<Flight> findFlight( @PathVariable String origin, @PathVariable String destination, @PathVariable Integer day, @PathVariable String month,
                                    @PathVariable Integer year , @RequestParam(name="dayBack",required=false) Integer dayBack,
                                    @RequestParam(name="monthBack",required=false) String monthBack){
        if(dayBack!= null && monthBack!=null)
            return flightService.getFlightsByOriginDestination(origin,destination, day, month, year, dayBack, monthBack);
        else
            return flightService.getFlightsByOriginDestination(origin,destination, day, month, year);



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
