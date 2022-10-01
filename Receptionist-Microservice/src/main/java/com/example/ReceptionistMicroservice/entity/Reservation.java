package com.example.ReceptionistMicroservice.entity;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.Transient;
import org.springframework.data.mongodb.core.mapping.Document;

import javax.validation.constraints.NotNull;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Document(collection = "Reservation")
public class Reservation {
    @Transient
    public static final  String SEQUENCE_NAME="user_sequence";

    @Id
    private int id;
    @NotNull
    private int roomNo;
    @NotNull
    private int children;
    @NotNull
    private int adults;
    @NotNull
    private String checkindate;
    @NotNull
    private String checkoutdate;
}
