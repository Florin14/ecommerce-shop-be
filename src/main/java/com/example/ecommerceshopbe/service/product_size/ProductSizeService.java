package com.example.ecommerceshopbe.service.product_size;

import com.example.ecommerceshopbe.controller.dto.request.GenderRequestDTO;
import com.example.ecommerceshopbe.controller.dto.request.ProductSizeRequestDTO;
import com.example.ecommerceshopbe.dao.model.Gender;
import com.example.ecommerceshopbe.dao.model.ProductSize;

import java.util.List;
import java.util.Optional;

public interface ProductSizeService {
    Optional<ProductSize> findById(Long id);

    List<ProductSize> getAll();

    ProductSize saveProductSize(ProductSizeRequestDTO productSizeRequestDTO);

    ProductSize updateProductSize(ProductSizeRequestDTO productSizeRequestDTO, Long id);

    void deleteProductSizeById(Long id);

}
