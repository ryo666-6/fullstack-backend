package com.portfoilo.fullstackbackend.Security;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Component;

@Component
public class SecuritySession {
    public String getEmail() {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        if(authentication != null) {
            Object principal = authentication.getPrincipal();
            if(principal instanceof UserDetails) {
                return ((((UserDetails) principal).getUsername()));
            }
        }
        return null;
    }
}
