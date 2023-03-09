package com.portfoilo.fullstackbackend.Service;

import com.portfoilo.fullstackbackend.Model.User;

import com.portfoilo.fullstackbackend.Repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class UserRegistrationService {
    @Autowired
    private PasswordEncoder passwordEncoder;

    @Autowired
    @Lazy
    private UserRepository userRepository;

    public void userRegistration(Integer id ,String email, String password) {
        String hashedPassword = passwordEncoder.encode(password);
        userRepository.saveAndFlush(new User(id, email, hashedPassword));
    }
}
