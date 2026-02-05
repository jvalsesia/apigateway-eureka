package com.github.jvalsesia.userservice.dto;

import com.github.jvalsesia.userservice.model.User;

public class Mapper {

    public User toUser(UserRequestDto userRequestDto) {
        User user = new User();
        user.setFirstName(userRequestDto.firstName());
        user.setLastName(userRequestDto.lastName());
        user.setAge(userRequestDto.age());
        user.setEmail(userRequestDto.email());
        return user;

    }

    public UserResponseDto toUserResponse(User user) {
        UserResponseDto userResponseDto = new UserResponseDto(
                user.getId(),
                user.getFirstName(),
                user.getLastName(),
                user.getAge(),
                user.getEmail());
        return userResponseDto;
    }
}
