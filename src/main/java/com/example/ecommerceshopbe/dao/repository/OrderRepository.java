package com.example.ecommerceshopbe.dao.repository;

import com.example.ecommerceshopbe.dao.model.Order;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderRepository extends JpaRepository<Order, Long> {
}
