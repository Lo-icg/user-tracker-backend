package com.tracker.rest.api.controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.tracker.rest.api.model.User;
import com.tracker.rest.api.service.UserService;

@RestController
@RequestMapping("/user")
@CrossOrigin(origins = "http://localhost:3000") // Allow frontend requests
public class UserController {

    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping()
    public List<User> getAllUser() {
        return userService.getAllUser();
    }

    // @PostMapping("/signup")
    // public String createAccount(@RequestParam String username, @RequestParam
    // String password,
    // @RequestParam String email) {

    // return userService.createAccount(username, password, email);
    // }

    @PostMapping("/signup")
    public ResponseEntity<?> signup(@RequestBody User user) {
        String response = userService.signup(user);

        if (response.equals("Email already taken")) {
            return ResponseEntity.status(HttpStatus.CONFLICT).body(response); // 409 Conflict
        }
        return ResponseEntity.ok("User signing up success..."); // 200 OK
    }

    @DeleteMapping("/deleteaccount")
    public String deleteAccount(@RequestParam String username) {
        return userService.deleteAccount(username);
    }

}
