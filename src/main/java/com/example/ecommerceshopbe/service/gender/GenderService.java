package com.example.ecommerceshopbe.service.gender;

import com.example.ecommerceshopbe.controller.dto.request.BrandRequestDTO;
import com.example.ecommerceshopbe.controller.dto.request.GenderRequestDTO;
import com.example.ecommerceshopbe.dao.model.Brand;
import com.example.ecommerceshopbe.dao.model.Gender;

import java.util.List;
import java.util.Optional;

public interface GenderService {
    Optional<Gender> findById(Long id);

    List<Gender> getAll();

    Gender saveGender(GenderRequestDTO genderRequestDTO);

    Gender updateGender(GenderRequestDTO genderRequestDTO, Long id);

    void deleteGenderById(Long id);

}
