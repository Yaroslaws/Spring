package com.example.controller;


import com.example.domain.User;
import com.example.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.StringUtils;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.client.RestTemplate;

import javax.validation.Valid;
import java.util.Collections;
import java.util.Map;

@Controller
public class RegistrationController {
    private final UserService userService;

    public RegistrationController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("/registration")
    public String registration() {
        return "registration";
    }

    @PostMapping("/registration")
    public String addUser(
            @RequestParam("password2") String passwordConfig,
            @Valid User user,
            BindingResult bindingResult,
            Model model
    ) {

        boolean isConfirmIsEmpty = StringUtils.isEmpty(passwordConfig);

        if (isConfirmIsEmpty) {
            model.addAttribute("password2Error", "Password conform cannot be empty");
        }

        if (user.getPassword() != null && !user.getPassword().equals(passwordConfig)) {
            model.addAttribute("passwordError", "Password are different");
        }

        if (isConfirmIsEmpty || bindingResult.hasErrors()) {
            return "registration";
        }


        if (!userService.addUser(user)) {
            model.addAttribute("message", "User exists!");
            return "registration";
        }

        return "redirect:/login";
    }

    @GetMapping("/activate/{code}")
    public String activate(Model model, @PathVariable String code) {
        boolean isActivated = userService.activateUser(code);

        if (isActivated) {
            model.addAttribute("message", "Pirate success activated");
        } else {
            model.addAttribute("message", "Pirate is not found");
        }

        return "login";
    }
}
