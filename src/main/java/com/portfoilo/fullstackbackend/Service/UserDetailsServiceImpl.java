package com.portfoilo.fullstackbackend.Service;

import com.portfoilo.fullstackbackend.Model.User;
import com.portfoilo.fullstackbackend.Model.UserDetailsImpl;
import com.portfoilo.fullstackbackend.Repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class UserDetailsServiceImpl implements UserDetailsService {
    @Autowired
    private UserRepository userRepository;

    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
        User user = userRepository.findByEmail(email);
        if(user == null) {
            throw new UsernameNotFoundException("Not Found");
        }
        return new UserDetailsImpl(user);
    }
}
