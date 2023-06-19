package com.jesthercostinar.joblisting.controller;

import com.jesthercostinar.joblisting.dto.UserDto;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class AuthController {


    @GetMapping("/register")
    public String showRegistrationPage(Model model) {
        UserDto user = new UserDto();
        model.addAttribute("user", user);

        return "auth/register";
    }
}
