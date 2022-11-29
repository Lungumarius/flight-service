package com.example.flightservice.service;

import com.example.flightservice.model.Flight;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.time.Month;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicReference;

@Service
public class FlightService {


    Flight flight = new Flight(1L,"123AB",Flight.Origin.Spain, Flight.Destination.Romania,
            "WizzAir",
            LocalDateTime.of(2022, Month.NOVEMBER, 22, 9, 00, 00),
            LocalDateTime.of(2022, Month.NOVEMBER, 22, 14, 00, 00),
            0,true,1, 200L,false);
    Flight flight2 = new Flight(2L,"124AC", Flight.Origin.Romania, Flight.Destination.Spain,"BlueAir",
            LocalDateTime.of(2022, Month.NOVEMBER, 22, 9, 00, 00),
            LocalDateTime.of(2022, Month.NOVEMBER, 22, 14, 00, 00),
            0,true,1,200L,false);
    List<Flight> list2 = new ArrayList<>(){{
        list2.add(flight);
        list2.add(flight2);
    }};
    public Flight getFlightById(Long id){
        AtomicReference<Flight> flight3 = new AtomicReference<>(new Flight());
        list2.forEach(flightIt ->{
            if(id == flight.getId()){

                flight3.set(flightIt);

            }
        });
        return flight3.get();
    }
    public List<Flight> getFlightsByOriginDestinationDepartureArrival(String origin, String destination, Integer dayDeparture, Integer dayArrival, Integer hourDeparture, Integer hourArrival
                                                                      String month, Integer year ){
        List<Flight> list3 = new ArrayList<>();
        list2.forEach(flightIt ->{
            if(origin.equals(String.valueOf(flightIt.getOrigin()))
                    && destination.equals(String.valueOf(flightIt.getDestination())) && day.equals(flightIt.get)){
                list3.add(flightIt);
            }
        });
        return list3;
    }
//    public List<Flight> getFlightsByFilters(String origin,String destination,String airline,
//                                            Integer scales,Boolean allowLuggage,Integer schedule){
//        List<Flight> list = new ArrayList<>();
//        list2.forEach(flightIt ->{
//            if(flightIt.getAllowLuggage().equals(allowLuggage) && String.valueOf(flightIt.getOrigin()).equals(origin) &&
//                    String.valueOf(flightIt.getDestination()).equals(destination) && flightIt.getAirline().equals(airline) &&
//                    flightIt.getScalesNumber().equals(scales) && flightIt.getDateTimeDeparture().getHour() == schedule)
//        });
//    }

}
