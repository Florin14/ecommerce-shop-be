package com.example.ecommerceshopbe.controller.dto.request;

import com.example.ecommerceshopbe.dao.model.Role;
import lombok.Builder;
import lombok.Data;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Data
@Builder
public class UserRegisterRequestDTO {
    @NotBlank
    private String fullName;
    @NotBlank
    private String username;

    @NotBlank
    private String firstName;
    @NotBlank
    private String lastName;
    @NotBlank
    @Size(min = 7)
    private String password;
    private String profilePicture;
    private Role role;
}
