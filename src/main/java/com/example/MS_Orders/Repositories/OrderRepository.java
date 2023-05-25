package com.example.MS_Orders.Repositories;

import com.example.MS_Orders.Models.Orders;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderRepository extends JpaRepository<Orders,Long> {
}
