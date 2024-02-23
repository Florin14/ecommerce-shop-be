package com.example.ecommerceshopbe.service.order;

import com.example.ecommerceshopbe.controller.dto.request.OrderRequestDTO;
import com.example.ecommerceshopbe.controller.dto.request.ProductRequestDTO;
import com.example.ecommerceshopbe.dao.model.Order;
import com.example.ecommerceshopbe.dao.model.Product;

import java.util.List;
import java.util.Optional;

public interface OrderService {
    Optional<Order> findById(Long id);

    List<Order> getAll();

    Order saveOrder(OrderRequestDTO orderRequestDTO);

    Order updateOrder(OrderRequestDTO orderRequestDTO, Long id);

    void deleteOrderById(Long id);

}
