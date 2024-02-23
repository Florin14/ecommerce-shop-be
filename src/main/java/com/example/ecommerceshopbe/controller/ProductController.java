package com.example.ecommerceshopbe.controller;

import com.example.ecommerceshopbe.controller.dto.mapper.BrandMapper;
import com.example.ecommerceshopbe.controller.dto.mapper.CategoryMapper;
import com.example.ecommerceshopbe.controller.dto.mapper.GenderMapper;
import com.example.ecommerceshopbe.controller.dto.request.ProductRequestDTO;
import com.example.ecommerceshopbe.controller.dto.response.brand.BrandResponseDTO;
import com.example.ecommerceshopbe.controller.dto.response.category.CategoryResponseDTO;
import com.example.ecommerceshopbe.controller.dto.response.gender.GenderResponseDTO;
import com.example.ecommerceshopbe.controller.dto.response.product.ProductResourcesResponseDTO;
import com.example.ecommerceshopbe.controller.dto.response.product.ProductResponseDTO;
import com.example.ecommerceshopbe.dao.model.Brand;
import com.example.ecommerceshopbe.dao.model.Category;
import com.example.ecommerceshopbe.dao.model.Gender;
import com.example.ecommerceshopbe.dao.model.Product;
import com.example.ecommerceshopbe.service.brand.BrandService;
import com.example.ecommerceshopbe.service.category.CategoryService;
import com.example.ecommerceshopbe.service.gender.GenderService;
import com.example.ecommerceshopbe.service.product.ProductService;
import com.example.ecommerceshopbe.controller.dto.mapper.ProductMapper;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import javax.persistence.EntityNotFoundException;
import java.net.URI;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/products")
@Getter
@RequiredArgsConstructor
public class ProductController {

    private final ProductService productService;
    private final CategoryService categoryService;
    private final BrandService brandService;
    private final GenderService genderService;
    private final ProductMapper productMapper;
    private final BrandMapper brandMapper;
    private final CategoryMapper categoryMapper;
    private final GenderMapper genderMapper;

    @GetMapping()
    public ResponseEntity<List<ProductResponseDTO>> getProducts() {
        List<Product> products = productService.getAll();
        List<ProductResponseDTO> productResponseDTOS = products.stream()
                .map(product -> getProductMapper().toDTO(product)).collect(Collectors.toList());

        return ResponseEntity.ok().body(productResponseDTOS);
    }

    @PostMapping()
    public ResponseEntity<ProductResponseDTO> addProduct(@RequestPart("product") ProductRequestDTO product, @RequestPart("images") List<MultipartFile> images) {
        URI uri = URI.create((ServletUriComponentsBuilder.fromCurrentContextPath().path("/addProduct").toUriString()));

        return ResponseEntity.created(uri).body(getProductMapper().toDTO(getProductService().saveProduct(product, images)));
    }

    @PutMapping("/{id}")
    public ResponseEntity<ProductResponseDTO> updateProduct(@RequestBody ProductRequestDTO product,
                                                            @PathVariable Long id) {
        return ResponseEntity.ok().body(getProductMapper().toDTO(getProductService().
                updateProduct(product, id)));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Long> deleteProduct(@PathVariable Long id) {

        final Product product = getProductService().findById(id).
                orElseThrow(EntityNotFoundException::new);
        productService.deleteProductById(product.getId());
        return new ResponseEntity<>(id, HttpStatus.OK);

    }

    @GetMapping("/resources")
    public ResponseEntity<ProductResourcesResponseDTO> getProductsResources() {
        List<Brand> brands = brandService.getAll();
        List<Category> categories = categoryService.getAll();
        List<Gender> genders = genderService.getAll();
        List<BrandResponseDTO> brandResponseDTOS = brands.stream()
                .map(brand -> getBrandMapper().toDTO(brand)).toList();
        List<CategoryResponseDTO> categoriesResponseDTOS = categories.stream()
                .map(category -> getCategoryMapper().toDTO(category)).toList();
        List<GenderResponseDTO> gendersResponseDTOS = genders.stream()
                .map(gender -> getGenderMapper().toDTO(gender)).toList();
        ProductResourcesResponseDTO responseDTO = ProductResourcesResponseDTO.builder()
                .brands(brandResponseDTOS)
                .categories(categoriesResponseDTOS)
                .genders(gendersResponseDTOS)
                .build();

        return ResponseEntity.ok().body(responseDTO);
    }
}
