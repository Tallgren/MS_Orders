package com.example.MS_Orders.Models;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
public class Customer {


    @Id
    @GeneratedValue
    protected Long id;
    protected String name;
    protected String socSecNr;


}
