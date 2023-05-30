package com.example.MS_Orders.Controllers;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.NOT_FOUND)
public class OrdersNotFoundException extends RuntimeException{

    public OrdersNotFoundException(Long id) {
        super("Could not find order " +  id);
    }
}
