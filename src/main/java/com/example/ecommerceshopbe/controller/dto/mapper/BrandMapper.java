package com.example.ecommerceshopbe.controller.dto.mapper;

import com.example.ecommerceshopbe.controller.dto.response.brand.BrandResponseDTO;
import com.example.ecommerceshopbe.dao.model.Brand;
import org.mapstruct.Mapper;


@Mapper(componentModel = "spring")
public interface BrandMapper {
    BrandResponseDTO toDTO(Brand brand);
}
