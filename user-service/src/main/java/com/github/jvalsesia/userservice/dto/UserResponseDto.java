package com.github.jvalsesia.userservice.dto;

import java.util.UUID;

public record UserResponseDto(UUID id, String firstName, String lastName, Integer age, String email) {

}
