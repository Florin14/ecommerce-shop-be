package com.example.ecommerceshopbe.controller.dto.request;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class ProductRequestDTO {
    private String name;
    private String description;
    private double price;
    private int stockQuantity;
    private Long brand_id;
    private Long category_id;
    private Long gender_id;
    private String sku;
}
