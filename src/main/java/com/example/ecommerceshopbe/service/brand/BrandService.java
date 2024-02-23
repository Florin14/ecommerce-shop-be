package com.example.ecommerceshopbe.service.brand;

import com.example.ecommerceshopbe.controller.dto.request.BrandRequestDTO;
import com.example.ecommerceshopbe.controller.dto.request.ProductRequestDTO;
import com.example.ecommerceshopbe.dao.model.Brand;
import com.example.ecommerceshopbe.dao.model.Product;

import java.util.List;
import java.util.Optional;

public interface BrandService {
    Optional<Brand> findById(Long id);

    List<Brand> getAll();

    Brand saveBrand(BrandRequestDTO brandRequestDTO);

    Brand updateBrand(BrandRequestDTO brandRequestDTO, Long id);

    void deleteBrandById(Long id);

}
