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
@Document(collection = "SetRates")
public class SetRates {

    @Transient
    public static final  String SEQUENCE_NAME="user_sequence";


    @Id
    private int id;
    private  int guest;
    private int days;
    private int nightPrice;
    private int extension;

}
