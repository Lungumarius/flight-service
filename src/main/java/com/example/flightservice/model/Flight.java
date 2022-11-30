package com.example.flightservice.model;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.format.annotation.DateTimeFormat;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
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
    private String transitTime;
    private Boolean allowLuggage;
    private Integer layoverNumber;
    private Long price;

    @JsonFormat(pattern = "yyyy-MM-dd HH:mm")
    public LocalDateTime getDateTimeDeparture() {
        return dateTimeDeparture;
    }
}
