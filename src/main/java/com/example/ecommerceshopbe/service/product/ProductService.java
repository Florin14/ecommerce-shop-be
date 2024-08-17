package com.example.ecommerceshopbe.service.product;

import com.example.ecommerceshopbe.controller.dto.request.ProductRequestDTO;
import com.example.ecommerceshopbe.controller.dto.request.ProductSizeStockRequestDTO;
import com.example.ecommerceshopbe.dao.model.Product;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;
import java.util.Optional;

public interface ProductService {
    Optional<Product> findById(Long id);

    List<Product> getAll();

    Product saveProduct(ProductRequestDTO productRequestDTO, List<ProductSizeStockRequestDTO> productStock);

    Product updateProduct(ProductRequestDTO productRequestDTO, Long id);

    void deleteProductById(Long id);

}
