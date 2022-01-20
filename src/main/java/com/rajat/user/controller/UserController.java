package com.rajat.user.controller;

import com.rajat.user.entities.User;
import com.rajat.user.services.UserService;
import com.rajat.user.valueobjects.ResponseTemplateVO;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@Slf4j
@RequestMapping("/users")
public class UserController {
    @Autowired
    private UserService userService;

    @PostMapping("/")
    public User saveUser(@RequestBody User user){
        log.info("Inside saveUser method of UserController");
        return userService.saveUser(user);
    }

    @GetMapping("/user/{id}")
    public User getUserByID(@PathVariable("id") int userID){
        log.info("Inside getUserByID method of User Controller");

        return userService.getUserByID(userID);
    }

    @GetMapping("/{id}")
    public ResponseTemplateVO getUserWithDepartment(@PathVariable("id") int userID){
        log.info("Inside getUserWithDepartment of User Controller");
        return userService.getUserWithDepartment(userID);
    }

}
