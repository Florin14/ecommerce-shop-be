package com.example.ecommerceshopbe.service.product;

import com.example.ecommerceshopbe.controller.dto.request.ProductRequestDTO;
import com.example.ecommerceshopbe.dao.model.*;
import com.example.ecommerceshopbe.dao.repository.*;
import com.example.ecommerceshopbe.service.brand.BrandService;
import com.example.ecommerceshopbe.service.category.CategoryService;
//import com.example.ecommerceshopbe.service.files.FilesService;
import com.example.ecommerceshopbe.service.files.FilesService;
import com.example.ecommerceshopbe.service.gender.GenderService;
import lombok.Data;
import lombok.Getter;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import javax.persistence.EntityNotFoundException;
import java.util.List;
import java.util.Optional;

@Data
@Getter
@Service
public class ProductServiceImpl implements ProductService {
    private final ProductRepository productRepository;
    private final ProductImageRepository productImageRepository;
    private final BrandRepository brandRepository;
    private final CategoryRepository categoryRepository;
    private final GenderRepository genderRepository;
    private final FilesService filesService;
    private final ProductImageRepository imageRepository;

    @Override
    public Optional<Product> findById(Long id) {
        return productRepository.findById(id);
    }

    @Override
    public List<Product> getAll() {
        return productRepository.findAll();
    }

    @Override
    public Product saveProduct(ProductRequestDTO productDTO, List<MultipartFile> images) {
        Brand brand = brandRepository.findById(productDTO.getBrand_id())
                .orElseThrow(() -> new EntityNotFoundException("Brand not found with id: " + productDTO.getBrand_id()));
        Category category = categoryRepository.findById(productDTO.getCategory_id())
                .orElseThrow(() -> new EntityNotFoundException("Category not found with id: " + productDTO.getCategory_id()));
        Gender gender = genderRepository.findById(productDTO.getGender_id())
                .orElseThrow(() -> new EntityNotFoundException("Gender not found with id: " + productDTO.getGender_id()));



        final Product productToBeSaved = Product.builder()
                .name(productDTO.getName())
                .brand(brand)
                .gender(gender)
                .category(category)
                .description(productDTO.getDescription())
                .price(productDTO.getPrice())
                .sku(productDTO.getSku())
                .stockQuantity(productDTO.getStockQuantity())
                .build();

        Product savedProduct = productRepository.save(productToBeSaved);

        for (MultipartFile image : images) {
            String imageUrl = filesService.saveImageToDisk(image, savedProduct);
            ProductImage imageEntity = ProductImage.builder().product(savedProduct).imageUrl(imageUrl).build();

            imageRepository.save(imageEntity);
        }
        return savedProduct;
    }

    @Override
    public Product updateProduct(ProductRequestDTO productDTO, Long id) {
        Product product = findById(id).orElseThrow(EntityNotFoundException::new);

        product.setDescription(productDTO.getDescription());
        product.setPrice(productDTO.getPrice());

        return productRepository.save(product);

    }

    @Override
    public void deleteProductById(Long id) {
        productRepository.deleteById(id);
    }
}
