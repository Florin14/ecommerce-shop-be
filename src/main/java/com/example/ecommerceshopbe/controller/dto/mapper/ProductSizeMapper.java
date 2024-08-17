package com.example.ecommerceshopbe.controller.dto.mapper;

import com.example.ecommerceshopbe.controller.dto.response.product_size.ProductSizeResponseDTO;
import com.example.ecommerceshopbe.dao.model.ProductSize;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface ProductSizeMapper {
    ProductSizeResponseDTO toDTO(ProductSize productSize);

}
