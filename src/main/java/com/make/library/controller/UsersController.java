package com.make.library.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;


import com.make.library.entities.User;
import com.make.library.services.UserService;

import jakarta.servlet.http.HttpSession;

@Controller
public class UsersController {

    @Autowired
    private UserService userService;

   

    @PostMapping("/register")
    public String addUser(@ModelAttribute User user) {
        boolean userExists = userService.emailExists(user.getEmail());
        if (!userExists) {
            userService.addUser(user);
            return "registersuccess";
        } else {
            return "registerfail";
        }
    }

    @PostMapping("/login")
    public String validateUser(@RequestParam String email, @RequestParam String password, HttpSession session) {
        if (userService.validateUser(email, password)) {
            session.setAttribute("email", email);
            if (userService.getRole(email).equals("admin")) {
                return "adminhome";
            } else {
                return "userhome";
            }
        } else {
            return "loginfail";
        }
    }
}