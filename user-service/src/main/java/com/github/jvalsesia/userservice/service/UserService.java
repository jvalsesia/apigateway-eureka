package com.github.jvalsesia.userservice.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.github.jvalsesia.userservice.dto.Mapper;
import com.github.jvalsesia.userservice.dto.UserRequestDto;
import com.github.jvalsesia.userservice.dto.UserResponseDto;
import com.github.jvalsesia.userservice.model.User;
import com.github.jvalsesia.userservice.repository.UserRepository;

@Service
public class UserService {
    private final UserRepository userRepository;

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public List<UserResponseDto> userList() {
        List<UserResponseDto> userResponseDtos = userRepository.findAll().stream()
                .map(user -> new Mapper().toUserResponse(user))
                .toList();
        return userResponseDtos;
    }

    public UserResponseDto addUser(UserRequestDto userRequestDto) {
        Mapper mapper = new Mapper();
        User user = mapper.toUser(userRequestDto);
        if (user != null) {
            User userSaved = userRepository.save(user);
            UserResponseDto userResponse = mapper.toUserResponse(userSaved);
            return userResponse;
        } else {
            return null;
        }

    }

}
