package com.portfoilo.fullstackbackend.Controller;

import com.portfoilo.fullstackbackend.Model.User;
import com.portfoilo.fullstackbackend.Security.SecuritySession;
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

    @Autowired
    private SecuritySession securitySession;

    @GetMapping("/login")
    public String showLoginPage() {
        return "login";
    }

//    @GetMapping(value = "/todo")
//    public String firstPage(User user) {
//        System.out.println(securitySession.getEmail());
//        System.out.println(user.getEmail());
//        return "redirect:/todo/" + user.getId();
//    }

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
