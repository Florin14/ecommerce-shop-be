package com.example.ecommerceshopbe.controller.dto.mapper;

import com.example.ecommerceshopbe.controller.dto.response.product_image.ProductImageResponseDTO;
import com.example.ecommerceshopbe.dao.model.ProductImage;
import org.mapstruct.Mapper;

import java.util.Base64;

@Mapper(componentModel = "spring")
public interface ProductImageMapper {

    default ProductImageResponseDTO toDTO(ProductImage productImage) {
        if (productImage == null) {
            return null;
        }

        try {
            return ProductImageResponseDTO.builder()
                    .id(productImage.getId())
                    .imageName(productImage.getImageName())
                    .imageData(productImage.getImageData())
                    .build();
        } catch (Exception e) {
            return null;
        }
    }

}
