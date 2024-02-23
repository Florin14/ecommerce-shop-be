package com.example.ecommerceshopbe.controller.dto.response.brand;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class BrandResponseDTO {
    private Long id;
    private String name;
}
