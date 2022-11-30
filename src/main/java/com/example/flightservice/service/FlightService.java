package com.example.flightservice.service;

import com.example.flightservice.model.Flight;
import org.apache.commons.beanutils.BeanUtils;
import org.springframework.stereotype.Service;

import java.lang.reflect.InvocationTargetException;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.Month;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicReference;

@Service
public class FlightService {


    Flight flight = new Flight(1L,"123AB",Flight.Origin.Spain, Flight.Destination.Romania,
            "WizzAir", LocalDateTime.of(2022, Month.NOVEMBER, 22, 9,0),
            "2h 30m", true,3,306L);
    Flight flight2 = new Flight(2L,"125AB",Flight.Origin.Romania, Flight.Destination.Spain,
            "BlueAir", LocalDateTime.of(2022, Month.NOVEMBER, 23, 1,0),
            "4h 30m", false,1,326L);
    List<Flight> list2 = new ArrayList<>();

    public Flight getFlightById(Long id){
        list2.add(flight);
        list2.add(flight2);
Flight flight3 = new Flight();
        list2.forEach(flightIt ->{
            if(id.equals(flightIt.getId())){
                try {
                    BeanUtils.copyProperties(flight3,flightIt);
                } catch (IllegalAccessException | InvocationTargetException e) {
                    throw new RuntimeException(e);
                }
            }
        });
        return flight3;
    }
    public List<Flight> getFlightsByOriginDestination(String origin, String destination, Integer day, String month, Integer year ){
        list2.add(flight);
        list2.add(flight2);
        List<Flight> list3 = new ArrayList<>();
            list2.forEach(flightIt ->{
                if(origin.equals(String.valueOf(flightIt.getOrigin()))
                        && destination.equals(String.valueOf(flightIt.getDestination())) && day.equals(flightIt.getDateTimeDeparture().getDayOfMonth()) &&
                        month.equals(String.valueOf(flightIt.getDateTimeDeparture().getMonth())) && year.equals(flightIt.getDateTimeDeparture().getYear())){
                    list3.add(flightIt);
                }
                //now adding 3 days early / late trips as options, they ll be at the end of the list
                //maybe an option in the future to make an endpoint of similar trips in different days
                for(int k = 1; k<4; k++){
                    if(origin.equals(String.valueOf(flightIt.getOrigin())) && !list3.contains(flightIt)
                            && destination.equals(String.valueOf(flightIt.getDestination())) &&
                            (day.equals(flightIt.getDateTimeDeparture().getDayOfMonth()+k) || day < (flightIt.getDateTimeDeparture().getDayOfMonth())-k)
                            &&
                            month.equals(String.valueOf(flightIt.getDateTimeDeparture().getMonth())) && year.equals(flightIt.getDateTimeDeparture().getYear()))
                        list3.add(flightIt);
                }
                //Didn t handle in case 3 days later is actually next month
            });
        return list3;
    }
    //Overloading the method for round trips
    public List<Flight> getFlightsByOriginDestination(String origin, String destination, Integer day, String month, Integer year,
                                                      Integer dayOfComingBack, String monthOfComingBack){
        list2.add(flight);
        list2.add(flight2);
        List<Flight> list3 = new ArrayList<>();
        list2.forEach(flightIt ->{
            if(origin.equals(String.valueOf(flightIt.getOrigin()))
                    && destination.equals(String.valueOf(flightIt.getDestination())) &&
                    day.equals(flightIt.getDateTimeDeparture().getDayOfMonth()) &&
                    month.equals(String.valueOf(flightIt.getDateTimeDeparture().getMonth())) &&
                    year.equals(flightIt.getDateTimeDeparture().getYear())){
                {list3.add(flightIt);
                // Iterating through the list again to find the flight to come back
                list2.forEach(backFlight -> {
                    if (origin.equals(String.valueOf(flightIt.getDestination()))
                            && destination.equals(String.valueOf(flightIt.getOrigin())) &&
                            dayOfComingBack.equals(flightIt.getDateTimeDeparture().getDayOfMonth()) &&
                            monthOfComingBack.equals(String.valueOf(flightIt.getDateTimeDeparture().getMonth()))
                            && year.equals(flightIt.getDateTimeDeparture().getYear())) {
                        list3.add(flightIt);
                    }
                });
            }}});
        return list3;}
            //Can implement 3 days methods too but it s crazy long already
//                for(int k = 1; k<4; k++){
//                    if(destination.equals(String.valueOf(flightIt.getOrigin()))
//                            && origin.equals(String.valueOf(flightIt.getDestination())) &&
//                            (day.equals(flightIt.getDateTimeDeparture().getDayOfMonth()+k) || day < (flightIt.getDateTimeDeparture().getDayOfMonth())-k)
//                            &&
//                            month.equals(String.valueOf(flightIt.getDateTimeDeparture().getMonth())) && year.equals(flightIt.getDateTimeDeparture().getYear()))
//                        list3.add(flightIt);
//                }
            //now adding 3 days early / late trips as options, they ll be at the end of the list
            //maybe an option in the future to make an endpoint of similar trips in different days

            //Didn t handle in case 3 days later is actually next month







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
