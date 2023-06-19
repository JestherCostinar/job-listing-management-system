package com.jesthercostinar.joblisting.controller;

import com.jesthercostinar.joblisting.dto.UserDto;
import com.jesthercostinar.joblisting.entity.User;
import com.jesthercostinar.joblisting.service.UserService;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
@AllArgsConstructor
public class AuthController {

    private UserService userService;

    @GetMapping("/register")
    public String showRegistrationPage(Model model) {
        UserDto user = new UserDto();
        model.addAttribute("user", user);

        return "auth/register";
    }

    @PostMapping("/register/save")
    public String register(@Valid @ModelAttribute("user") UserDto user,
                           BindingResult result,
                           Model model) {

        User existingUser = userService.findUserByEmail(user.getEmail());

        if (existingUser != null && existingUser.getEmail() != null && !existingUser.getEmail().isEmpty()) {
            result.rejectValue("email", null, "Email already exist");
        }

        if (result.hasErrors()) {
            model.addAttribute("user", user);

            return "auth/register";
        }

        userService.saveUser(user);

        return "redirect:/register?success";
    }
}
