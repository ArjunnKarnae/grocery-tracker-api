package com.grocerytracker.service;

import com.grocerytracker.dto.AuthRequestDTO;
import com.grocerytracker.dto.AuthResponseDTO;
import com.grocerytracker.entity.UserEntity;
import com.grocerytracker.mapper.AuthMapper;
import com.grocerytracker.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class AuthServiceImpl implements IAuthService {

   private final AuthenticationManager authenticationManager;

   private final JwtService jwtService;

   private final BCryptPasswordEncoder bCryptPasswordEncoder;

   private final UserRepository userRepository;

    @Autowired
    public AuthServiceImpl(AuthenticationManager authenticationManager, JwtService jwtService, BCryptPasswordEncoder bCryptPasswordEncoder, UserRepository userRepository) {
        this.authenticationManager = authenticationManager;
        this.jwtService = jwtService;
        this.bCryptPasswordEncoder = bCryptPasswordEncoder;
        this.userRepository = userRepository;
    }

    @Override
    public AuthResponseDTO registerUser(AuthRequestDTO authRequestDTO) {
        UserEntity userEntityToRegister = AuthMapper.mapAuthDtoToUserEntity(authRequestDTO);
        userEntityToRegister.setPassword(bCryptPasswordEncoder.encode(authRequestDTO.getPassword()));
        try{
            UserEntity registeredUser = this.userRepository.insert(userEntityToRegister);
            return new AuthResponseDTO(true, "User registered successfully");
        } catch (Exception e) {
            return new AuthResponseDTO(false, "User registered failed");
        }
    }

    @Override
    public AuthResponseDTO verifyLogin(AuthRequestDTO authRequestDTO) {
        Authentication authentication = authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(authRequestDTO.getUserName(), authRequestDTO.getPassword()));
        AuthResponseDTO authResponseDTO = new AuthResponseDTO();
        if(authentication.isAuthenticated()){
            return new AuthResponseDTO(true, "Login Success");
        }
        return new AuthResponseDTO(false, "Login failed");
    }
}
