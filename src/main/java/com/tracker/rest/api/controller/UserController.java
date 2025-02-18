package com.tracker.rest.api.controller;

import java.util.List;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.tracker.rest.api.model.User;
import com.tracker.rest.api.service.UserService;

@RestController
@RequestMapping("/user")
public class UserController {

    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping()
    public List<User> getAllUser() {
        return userService.getAllUser();
    }

    @PostMapping("/createaccount")
    public String createAccount(@RequestParam String username, @RequestParam String password,
            @RequestParam String email) {

        return userService.createAccount(username, password, email);
    }

    @DeleteMapping("/deleteaccount")
    public String deleteAccount(@RequestParam String username) {
        return userService.deleteAccount(username);
    }

}
