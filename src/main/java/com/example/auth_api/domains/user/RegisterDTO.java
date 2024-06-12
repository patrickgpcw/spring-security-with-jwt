package com.example.auth_api.domains.user;

public record RegisterDTO(String email, String password, UserRole role) {
}
