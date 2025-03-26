package com.jwt.example.basicauth.controller;

import com.jwt.example.basicauth.models.User;
import com.jwt.example.basicauth.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.security.Principal;
import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/api")
public class UserController {
    @Autowired
    private UserService userService;
@GetMapping("/user")
    public List<User> getUsers() {
        return userService.getUsers();
    }
    @GetMapping("/current-user")
    public String getLoggedUser(Principal principal) {
    return principal.getName();
    }
}
