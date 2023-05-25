package com.example.MS_Orders.Controllers;


import com.example.MS_Orders.Models.Customer;
import com.example.MS_Orders.Models.Orders;
import com.example.MS_Orders.Repositories.OrderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

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

    @GetMapping(path = "/demo")
    public @ResponseBody Customer getRandomCustomer() {
        String userResourceUrl = userServiceBaseUrl + "customers/all";
        // Error handling and null check is missing in this example
        Customer[] customers = restTemplate.getForObject(userResourceUrl, Customer[].class);
        int randomCustomer = new Random().nextInt(customers.length);
        Customer winner = customers[randomCustomer];
        return winner;
    }

    @RequestMapping("/all")
    public List<Orders> getAllOrders() {
        return orderRepo.findAll();
    }

    @RequestMapping("/orderById/{id}")
    public Orders getOrderById(@PathVariable Long id) {

        return orderRepo.findById(id).orElse(null);
    }
}