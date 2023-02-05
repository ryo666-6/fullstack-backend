package com.portfoilo.fullstackbackend.Controller;

import com.portfoilo.fullstackbackend.Service.UserRegistrationService;
import com.portfoilo.fullstackbackend.SignupForm;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class UserController {
    @Autowired
    @Lazy
    private UserRegistrationService userRegistrationService;

    @GetMapping("/")
    public String showTop() {
        return "index";
    }


    @GetMapping("/login")
    public String showLoginPage() {
        return "login";
    }

    @GetMapping("/signup")
    public String showUserRegistration(@ModelAttribute("signupForm") SignupForm signupForm) {
        return "signup";
    }

    @PostMapping("/signup")
    public String userRegistration(@Validated @ModelAttribute("signupForm") SignupForm signupForm, BindingResult result) {
        if(result.hasErrors()) {
            return "signup";
        }
        userRegistrationService.userRegistration(signupForm.getEmail(), signupForm.getPassword());
        return "redirect:/login";
    }
}
