package com.apps.quantitymeasurement.service;

import com.apps.quantitymeasurement.dto.AuthRequestDTO;
import com.apps.quantitymeasurement.dto.AuthResponseDTO;
import com.apps.quantitymeasurement.dto.RegisterRequestDTO;

public interface IAuthService {
    AuthResponseDTO login(AuthRequestDTO request);
    AuthResponseDTO register(RegisterRequestDTO request);
    void logout(String token);
}
