package com.example.ecommerceshopbe.dao.repository;

import com.example.ecommerceshopbe.dao.model.ProductImage;
import org.springframework.data.jpa.repository.JpaRepository;


public interface ProductImageRepository extends JpaRepository<ProductImage, Long> {
}