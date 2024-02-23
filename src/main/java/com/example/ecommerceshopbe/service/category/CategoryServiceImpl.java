package com.example.ecommerceshopbe.service.category;

import com.example.ecommerceshopbe.controller.dto.request.CategoryRequestDTO;
import com.example.ecommerceshopbe.controller.dto.request.ProductRequestDTO;
import com.example.ecommerceshopbe.dao.model.Category;
import com.example.ecommerceshopbe.dao.model.Product;
import com.example.ecommerceshopbe.dao.repository.CategoryRepository;
import com.example.ecommerceshopbe.dao.repository.ProductRepository;
import lombok.Data;
import lombok.Getter;
import org.springframework.stereotype.Service;

import javax.persistence.EntityNotFoundException;
import java.util.List;
import java.util.Optional;

@Data
@Getter
@Service
public class CategoryServiceImpl implements CategoryService {
    private final CategoryRepository categoryRepository;

    @Override
    public Optional<Category> findById(Long id) {
        return categoryRepository.findById(id);
    }

    @Override
    public List<Category> getAll() {
        return categoryRepository.findAll();
    }

    @Override
    public Category saveCategory(CategoryRequestDTO categoryDTO) {
        final Category productToBeSaved = Category.builder()
                .name(categoryDTO.getName())
                .build();
        return categoryRepository.save(productToBeSaved);

    }

    @Override
    public Category updateCategory(CategoryRequestDTO categoryDTO, Long id) {
        Category category = findById(id).orElseThrow(EntityNotFoundException::new);

        category.setName(categoryDTO.getName());

        return categoryRepository.save(category);

    }

    @Override
    public void deleteCategoryById(Long id) {
        categoryRepository.deleteById(id);
    }
}
