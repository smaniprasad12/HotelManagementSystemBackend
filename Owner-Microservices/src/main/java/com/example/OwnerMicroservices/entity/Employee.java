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
@Document(collection = "Employee")
public class Employee {
    @Transient
    public static final  String SEQUENCE_NAME="user_sequence";


    @Id

    private int id;

    private String Emp_Name;

    private String Emp_Address;

    private int salary;

    private String Occupation ;

    private String email;



   }