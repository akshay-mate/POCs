package com.example.jwt.controller;


import com.example.jwt.entity.User;
import com.example.jwt.logging.LogExecutionTime;
import com.example.jwt.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.PostConstruct;

@RestController
public class UserController {
    @Autowired
    private UserService userService;


// execute  when application starts
    @PostConstruct
    public void initRolesAndUsers(){
        userService.initRolesAndUser();
    }

    @PostMapping({"/registerNewUser"})
    @LogExecutionTime
    public User registerNewUser(@RequestBody User user) {
      return userService.registerNewUser(user);
    }

    @GetMapping({"/forAdmin"})  //this endpoint only accessible for admin role
    @PreAuthorize("hasRole('Admin')") // for only Admin token can access admin path
    public String forAdmin(){
        return "ADMIN TOKEN. This URL is only accessible to admin";
    }

    @GetMapping({"/forUser"})
    @LogExecutionTime
    @PreAuthorize("hasRole('User')")
    public String forUser(){
        return "{\n" +
                "  \"URL_status\": \"up\",\n" +
                "  \"message\": \"this URL generated from User token and only accessible to the user\"\n" +
                "}";
    }
}
