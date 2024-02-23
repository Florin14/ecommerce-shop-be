package com.example.ecommerceshopbe.dao.repository;

import com.example.ecommerceshopbe.dao.model.Category;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CategoryRepository extends JpaRepository<Category, Long> {

}