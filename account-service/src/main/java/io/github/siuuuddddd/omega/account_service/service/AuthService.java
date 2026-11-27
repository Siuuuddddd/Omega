package io.github.siuuuddddd.omega.account_service.service;


import io.github.siuuuddddd.omega.account_service.dto.auth.AuthResponse;
import io.github.siuuuddddd.omega.account_service.dto.auth.LoginRequest;
import io.github.siuuuddddd.omega.account_service.dto.auth.SignupRequest;

public interface AuthService {
    AuthResponse signup(SignupRequest request);

    AuthResponse login(LoginRequest request);
}
