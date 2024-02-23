package com.example.ecommerceshopbe.controller.dto.response.product;

import lombok.Builder;
import lombok.Data;

import java.math.BigDecimal;
import java.util.Date;

@Data
@Builder
public class ProductResponseDTO {
    private Long id;
    private String name;
    private String description;
    private double price;
    private int stockQuantity;
    private String categoryName;
    private String brandName;
}
