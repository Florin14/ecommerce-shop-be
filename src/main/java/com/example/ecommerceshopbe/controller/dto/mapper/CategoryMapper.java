package com.example.ecommerceshopbe.controller.dto.mapper;

import com.example.ecommerceshopbe.controller.dto.response.category.CategoryResponseDTO;
import com.example.ecommerceshopbe.dao.model.Category;
import org.mapstruct.Mapper;


@Mapper(componentModel = "spring")
public interface CategoryMapper {
    CategoryResponseDTO toDTO(Category category);
}
