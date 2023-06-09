package com.example.MS_Orders.Controllers;


import com.example.MS_Orders.Models.Customer;
import com.example.MS_Orders.Models.Orders;
import com.example.MS_Orders.Repositories.OrderRepository;
import jakarta.validation.constraints.Min;
import org.hibernate.exception.ConstraintViolationException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Random;

@RestController
@RequestMapping("/orders")
public class OrdersController {

    @Autowired
    private RestTemplate restTemplate;

    @Value("${user-service.url}")
    private String userServiceBaseUrl;
    private final OrderRepository orderRepo;
    public OrdersController(OrderRepository orderRepo) {
        this.orderRepo = orderRepo;
    }

    @GetMapping(path = "/demo/randomCustomer")
    public @ResponseBody Customer getRandomCustomer() {
        //Hämta lista på alla customers
        String userResourceUrl = userServiceBaseUrl + "customer/all";
        Customer[] customers = restTemplate.getForObject(userResourceUrl, Customer[].class);
        int randomCustomer = new Random().nextInt(customers.length);
        return customers[randomCustomer];
    }
    @RequestMapping("/all")
    public List<Orders> getAllOrders() {
        return orderRepo.findAll();
    }
    @RequestMapping("/orderById/{id}")
    public Orders getOrderById(@PathVariable Long id) {
        return orderRepo.findById(id).orElseThrow(() -> new OrdersNotFoundException(id));
    }
    @ResponseStatus(HttpStatus.NOT_FOUND)
    @ExceptionHandler(OrdersNotFoundException.class)
    public ErrorResponse handleOrdersNotFoundException(OrdersNotFoundException e){
        ErrorResponse error = new ErrorResponse();
        error.setMessage(e.getMessage());
        error.setTimestamp(LocalDateTime.now());
        error.setStatus(HttpStatus.NOT_FOUND);
        return error;
    }


}