package com.example.ecommerceshopbe.controller.dto.request;

import lombok.Data;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

@Data
public class UserLoginRequestDTO {
    @NotBlank
    private String email;
    @NotBlank
    @Size(min = 7)
    private String password;
}
