package com.example.ecommerceshopbe.controller.dto.response.product;

import com.example.ecommerceshopbe.controller.dto.response.brand.BrandResponseDTO;
import com.example.ecommerceshopbe.controller.dto.response.category.CategoryResponseDTO;
import com.example.ecommerceshopbe.controller.dto.response.gender.GenderResponseDTO;
import com.example.ecommerceshopbe.controller.dto.response.product_size.ProductSizeResponseDTO;
import com.example.ecommerceshopbe.dao.model.Brand;
import com.example.ecommerceshopbe.dao.model.Category;
import lombok.Builder;
import lombok.Data;

import java.util.List;

@Data
@Builder
public class ProductResourcesResponseDTO {
    private List<BrandResponseDTO> brands;
    private List<CategoryResponseDTO> categories;
    private List<GenderResponseDTO> genders;
    private List<ProductSizeResponseDTO> productSizes;
}
