package com.example.ecommerceshopbe.service.users;


import com.example.ecommerceshopbe.controller.dto.request.UserRegisterRequestDTO;
import com.example.ecommerceshopbe.dao.model.User;
import org.springframework.security.core.userdetails.UserDetailsService;

import java.util.List;
import java.util.Optional;

public interface UserService extends UserDetailsService {

    List<User> getAll();
    List<User> getAllMentors();

    Optional<User> getUserById(Long id);

    User saveUser(UserRegisterRequestDTO userDTO);

    User updateUser(Long id, UserRequestDTO userDTO);

    void deleteUserByEmail(String email);

    void deleteUserById(Long id);

    User updateProfile(ProfileRequestDTO profileRequestDTO);

    List<User> findAllAnnouncementsUsersByMentor(User mentor);
}
