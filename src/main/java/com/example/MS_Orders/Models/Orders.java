package com.example.MS_Orders.Models;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Orders {

    @Id
    @GeneratedValue
    protected Long id;
    protected Date date;
    protected Long customer_id;
    protected Long product_id;

    public String getFormattedDate(Date date) {
        SimpleDateFormat format = new SimpleDateFormat("dd-MM-yyyy");
        return format.format(date);
    }

    public Orders(Date date) {
        this.date = date;
    }

    public Orders(Long id) {
        this.id = id;
    }

}