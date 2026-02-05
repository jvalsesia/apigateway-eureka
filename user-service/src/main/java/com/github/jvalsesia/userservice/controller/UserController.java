package com.github.jvalsesia.userservice.controller;

import org.springframework.web.bind.annotation.RestController;

import com.github.jvalsesia.userservice.dto.UserRequestDto;
import com.github.jvalsesia.userservice.dto.UserResponseDto;
import com.github.jvalsesia.userservice.service.UserService;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.GetMapping;

@RestController
public class UserController {

    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @PostMapping("users")
    public ResponseEntity<UserResponseDto> createUser(@RequestBody UserRequestDto userDto) {
        UserResponseDto userResponseDto = userService.addUser(userDto);
        return ResponseEntity.ok(userResponseDto);
    }

    @GetMapping("users")
    public ResponseEntity<List<UserResponseDto>> listUsers() {
        return ResponseEntity.ok(userService.userList());
    }

}
