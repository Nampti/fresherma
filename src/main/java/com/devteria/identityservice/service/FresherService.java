package com.devteria.identityservice.service;

import com.devteria.identityservice.dto.request.FresherCreationRequest;
import com.devteria.identityservice.dto.response.FresherResponse;
import com.devteria.identityservice.dto.request.FresherScoreUpdateRequest;
import com.devteria.identityservice.entity.Fresher;
import com.devteria.identityservice.entity.Role;
import com.devteria.identityservice.entity.User;
import com.devteria.identityservice.exception.AppException;
import com.devteria.identityservice.exception.ErrorCode;
import com.devteria.identityservice.mapper.FresherMapper;
import com.devteria.identityservice.repository.FresherRepository;
import com.devteria.identityservice.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import lombok.AccessLevel;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
public class FresherService {
    FresherRepository fresherRepository;
    UserRepository userRepository;
    FresherMapper fresherMapper;

    public List<FresherResponse> getAllFreshers() {
        return fresherRepository.findAll().stream()
                .map(fresherMapper::toFresherResponse)
                .collect(Collectors.toList());
    }

    public FresherResponse createFresher(FresherCreationRequest request) {
        Fresher fresher = fresherMapper.toFresher(request);
        fresher = fresherRepository.save(fresher);
    
        // Create and save User entity
        User user = new User();
        user.setName(request.getName()); 
        user.setUsername(request.getUsername()); 
        PasswordEncoder passwordEncoder = new BCryptPasswordEncoder(10);
        user.setPassword(passwordEncoder.encode(request.getPassword()));
        user.setEmail(request.getEmail());
        user.setRole(Role.FRESHER);
    
        userRepository.save(user);
    
        return fresherMapper.toFresherResponse(fresher);
    }


}