package com.grocerytracker.service;

import com.grocerytracker.dto.AuthRequestDTO;
import com.grocerytracker.dto.AuthResponseDTO;

public interface IAuthService {

    public AuthResponseDTO verifyLogin(AuthRequestDTO authRequestDTO);

    public AuthResponseDTO registerUser(AuthRequestDTO authRequestDTO);
}
