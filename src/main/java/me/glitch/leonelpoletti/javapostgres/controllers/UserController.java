package me.glitch.leonelpoletti.javapostgres.controllers;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import me.glitch.leonelpoletti.javapostgres.models.User;

import java.util.Vector;

@RestController
public class UserController {
    // Create:
    @RequestMapping(value = "users/add", method = RequestMethod.POST)
    public void createUser(User user) {
        
    }
    
    // Modify:
    @RequestMapping(value = "users/modify", method = RequestMethod.POST)
    public void modifyUser() {
        
    }
    
    // Delete:
    @RequestMapping(value = "users/remove/{userName}", method = RequestMethod.GET)
    public void deleteUser(@PathVariable("userName") String userName) {
        
    }
    
    // Find all:
    @RequestMapping(value = "users", method = RequestMethod.GET)
    public Vector<User> getUsers() {
        return null;
    }
}
