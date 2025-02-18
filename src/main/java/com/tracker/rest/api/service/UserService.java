package com.tracker.rest.api.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tracker.rest.api.model.User;
import com.tracker.rest.api.repository.UserRepository;

import jakarta.transaction.Transactional;

@Service
@Transactional
public class UserService {

    private final UserRepository userRepository;

    @Autowired
    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public List<User> getAllUser() {
        return userRepository.findAll();
    }

    public String createAccount(String username, String password, String email) {

        var consoleOutput = "\nAccount";

        if (userRepository.existsByUserName(username)) {
            consoleOutput += " username already exist";
            System.out.println(consoleOutput);
            return "Username already exist";
        }

        if (userRepository.existsByUserEmail(email)) {
            consoleOutput += " email already taken";
            System.out.println(consoleOutput);
            return "Email already taken";
        }

        User user = User.createAccount(username, password, email);
        userRepository.save(user);

        consoleOutput += " created successfully";
        System.out.println(consoleOutput);
        return "User created successfully!";
    }

    public String deleteAccount(String username) {

        if (userRepository.existsByUserName(username)) {
            // userRepository.findAll().removeIf(u -> u.getUserName().equals(username));
            // userRepository.delete
            userRepository.deleteByUserName(username);
            return String.format("Account username(%s) deleted successfully.", username);
        }

        return "Account username not found";
    }
}