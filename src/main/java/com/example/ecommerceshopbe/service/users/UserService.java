package com.example.ecommerceshopbe.service.users;

import com.example.ecommerceshopbe.controller.dto.request.UserRequestDTO;
import com.example.ecommerceshopbe.dao.model.User;
import org.springframework.security.core.userdetails.UserDetailsService;

import java.util.List;
import java.util.Optional;

public interface UserService extends UserDetailsService {

    List<User> getAll();

    Optional<User> getUserById(Long id);

    User saveUser(UserRequestDTO userDTO);

    User updateUser(Long id, UserRequestDTO userDTO);

    void deleteUserByEmail(String email);

    void deleteUserById(Long id);


//    Optional<UserProfilePicture> findUserProfilePicture(Long userId);
//
//    UserProfilePicture saveUserProfilePicture(UserProfilePicture userProfilePicture);
//
//    void updateUserProfilePicture(Long userId, byte[] imageData);
}
