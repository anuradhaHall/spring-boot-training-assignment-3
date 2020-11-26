package com.wipro.assignment.controllers;

import com.wipro.assignment.entities.User;
import com.wipro.assignment.services.UserService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserController {
    
    @Autowired
    private UserService userService;

    @GetMapping("/finduser")
    @ResponseBody
    public ResponseEntity<User> findByID(@RequestParam(value = "id") Long id){
        return userService.findByID(id);
    }

    @PostMapping("/adduser")
    public ResponseEntity<String> addUser(@RequestBody User user){
        return userService.addUser(user);
    }

}
