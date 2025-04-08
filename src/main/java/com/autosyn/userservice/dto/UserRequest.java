package com.autosyn.userservice.dto;

import jakarta.validation.constraints.*;
import lombok.Data;


@Data
public class UserRequest {
    @NotBlank
    private String name;

    @Email
    @NotBlank
    private String email;

    @Size(min = 6)
    @NotBlank
    private String password;

    // Getters and setters
}
