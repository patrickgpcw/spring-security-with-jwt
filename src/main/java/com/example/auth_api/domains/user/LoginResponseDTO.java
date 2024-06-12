package com.example.auth_api.domains.user;

public record LoginResponseDTO(String token) {
    public LoginResponseDTO(User user){ this(user.getEmail()); }
}
