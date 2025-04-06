package com.kodilla.smarthomeshop.controller;

import com.kodilla.smarthomeshop.domain.RegistrationDto;
import com.kodilla.smarthomeshop.domain.User;
import com.kodilla.smarthomeshop.service.UserService;
import jakarta.validation.Valid;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;


@Controller
@RequestMapping
public class AuthorisationController {

    private UserService userService;

    public AuthorisationController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("/login")
    public String login() {
        return "login";
    }

    @GetMapping("/register")
    public String getRegisterForm(Model model) {
        RegistrationDto user = new RegistrationDto();
        model.addAttribute("user", user);

        return "register";
    }

    @PostMapping("/register/save")
    public String register(@Valid @ModelAttribute("user")RegistrationDto user,
                           BindingResult result, Model model) {
        User existingUserEmail = userService.findByEmail(user.getEmail());
        userService.saveUser(user);
        return "success";
    }

    @GetMapping("/success")
    public String success() {
        return "success";
    }

    @GetMapping("/success_login")
    public String successLogin() {
        return "success_login";
    }

}

