package com.example.ecommerceshopbe.service.category;

import com.example.ecommerceshopbe.controller.dto.request.CategoryRequestDTO;
import com.example.ecommerceshopbe.controller.dto.request.ProductRequestDTO;
import com.example.ecommerceshopbe.dao.model.Category;
import com.example.ecommerceshopbe.dao.model.Product;

import java.util.List;
import java.util.Optional;

public interface CategoryService {
    Optional<Category> findById(Long id);

    List<Category> getAll();

    Category saveCategory(CategoryRequestDTO categoryRequestDTO);

    Category updateCategory(CategoryRequestDTO categoryRequestDTO, Long id);

    void deleteCategoryById(Long id);

}
