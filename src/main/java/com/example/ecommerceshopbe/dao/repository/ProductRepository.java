package com.example.ecommerceshopbe.dao.repository;

import com.example.ecommerceshopbe.dao.model.Product;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductRepository extends JpaRepository<Product, Long> {
}
