package com.example.OwnerMicroservices.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.Transient;
import org.springframework.data.mongodb.core.mapping.Document;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Document(collection = "Guest")
public class Guest  {
    @Transient
    public static final  String SEQUENCE_NAME="user_sequence";

    @Id
    private int id;
    private String name;
    private int roomNo;
    private Long phoneNo;
    private String email;
    private String gender;
    private String address;

}
