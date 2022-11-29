package com.example.flightservice.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Flight {
    public enum Origin {
        Spain,
        Romania,
        France,
        Greece,
        Italy
    }
    public enum Destination {
        Spain,
        Romania,
        France,
        Greece,
        Italy
    }
    private Long id;
    private String flightNumber;
    private Origin origin;
    private Destination destination;
    private String airline;
    private LocalDateTime dateTimeDeparture;
    private LocalDateTime dateTimeArrival;
    private Integer scalesNumber;
    private Boolean allowLuggage;
    private Integer layoverNumber;
    private Long price;
    // 0 - one way 1- round trip
    private Boolean tripType;

}
