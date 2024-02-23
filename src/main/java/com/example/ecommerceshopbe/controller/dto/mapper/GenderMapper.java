package com.example.ecommerceshopbe.controller.dto.mapper;

import com.example.ecommerceshopbe.controller.dto.response.gender.GenderResponseDTO;
import com.example.ecommerceshopbe.dao.model.Gender;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface GenderMapper {
    GenderResponseDTO toDTO(Gender gender);

}
