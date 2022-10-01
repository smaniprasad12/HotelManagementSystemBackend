package com.example.OwnerMicroservices.entity;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.Transient;
import org.springframework.data.mongodb.core.mapping.Document;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Document(collection = "Room")
public class Room {
    @Transient
    public static final  String SEQUENCE_NAME="user_sequence";

    @Id
    private int id;
    private int roomNo;
    private String roomType;
    private String isOccupied;
    private int roomCost;
    private String checkIn;
    private String checkOut;

}
