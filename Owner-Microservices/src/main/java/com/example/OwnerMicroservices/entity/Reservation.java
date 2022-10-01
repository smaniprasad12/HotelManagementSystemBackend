package com.example.OwnerMicroservices.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Reservation {
    @Id
    private int id;

    private int roomNo;
    private int children;
    private int adults;
    private String checkindate;
    private String checkoutdate;
}
