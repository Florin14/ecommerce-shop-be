package com.example.ecommerceshopbe.controller.dto.request;

import com.example.ecommerceshopbe.dao.model.Role;
import lombok.Builder;
import lombok.Data;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.util.Set;

@Data
@Builder
public class UserRequestDTO {
    @NotBlank
    private String firstName;
    @NotBlank
    private String lastName;
    @NotBlank
    private String username;
    @NotBlank
    @Size(min = 7)
    private String password;
    private String profilePicture;
    private Set<Long> interestAreaIds;
    @NotNull
    private Role role;
}
