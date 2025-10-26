package com.example.userService.service;

import com.example.userService.model.dto.UserRequestDTO;
import com.example.userService.model.dto.UserResponseDTO;
import com.example.userService.model.entity.User;
import com.example.userService.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@Service
@Transactional
@RequiredArgsConstructor
public class UserService {

    private final UserRepository userRepository;


    private UserResponseDTO toDTO(User user) {
        UserResponseDTO userResponseDTO = new UserResponseDTO();
        userResponseDTO.setUserName(user.getName());
        userResponseDTO.setEmail(user.getEmail());
        userResponseDTO.setAge(user.getAge());
        return userResponseDTO;
    }

    private User toUser(UserRequestDTO userRequestDTO) {
        User user = new User();
        user.setName(userRequestDTO.getUserName());
        user.setEmail(userRequestDTO.getEmail());
        user.setAge(userRequestDTO.getAge());
        return user;
    }


    public ResponseEntity<Void> createUser(UserRequestDTO userCreateDTO) {
        User user = new User();
        user.setName(userCreateDTO.getUserName());
        user.setEmail(userCreateDTO.getEmail());
        user.setAge(userCreateDTO.getAge());
        userRepository.save(user);
        return ResponseEntity.status(HttpStatus.CREATED).build();
    }

    public UserResponseDTO getUserById(int id) {
        User user = userRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("User not found"));
        return toDTO(user);
    }

    public List<UserResponseDTO> getAllUsers() {
        return userRepository.findAll()
                .stream()
                .map(this::toDTO)
                .collect(Collectors.toList());
    }

    public ResponseEntity<Void> updateUser(int id, UserRequestDTO userRequestDTO) {
        User user = userRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("User not found"));
        user.setName(userRequestDTO.getUserName());
        user.setEmail(userRequestDTO.getEmail());
        user.setAge(userRequestDTO.getAge());
        userRepository.save(user);
        return ResponseEntity.ok().build();
    }

    public ResponseEntity<Void> deleteUserById(int id){
        userRepository.deleteById(id);
        return ResponseEntity.ok().build();
    }

    public ResponseEntity<Void> deleteAllUsers(){
        userRepository.deleteAll();
        return ResponseEntity.ok().build();
    }
}
