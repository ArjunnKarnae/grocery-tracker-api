package com.grocerytracker.controller;


import com.grocerytracker.dto.*;
import com.grocerytracker.service.IAuthService;
import com.grocerytracker.service.JwtService;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequestMapping("/api/auth")
@RestController
public class AuthController {

    private final IAuthService authService;

    private final JwtService jwtService;

    @Autowired
    public AuthController(IAuthService authService, JwtService jwtService) {
        this.authService = authService;
        this.jwtService = jwtService;
    }

    @PostMapping("/login")
    public ResponseEntity<AuthResponseDTO> verifyLogin(@RequestBody AuthRequestDTO authRequestDTO){
        AuthResponseDTO authResponseDTO = this.authService.verifyLogin(authRequestDTO);
        String authToken = null;
        if(authResponseDTO.isSuccess()){
            authToken = this.jwtService.generateToken(authRequestDTO.getUserName());
        }
        return ResponseEntity.status(200).header("X-Auth-Token", authToken).body(authResponseDTO);
    }

    @PostMapping("/register")
    public ResponseEntity<AuthResponseDTO> registerUser(@RequestBody AuthRequestDTO authRequestDTO){
        AuthResponseDTO authResponseDTO = this.authService.registerUser(authRequestDTO);
        return ResponseEntity.status(201).body(authResponseDTO);
    }
}
