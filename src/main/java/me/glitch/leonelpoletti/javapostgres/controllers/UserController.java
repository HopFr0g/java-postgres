package me.glitch.leonelpoletti.javapostgres.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import me.glitch.leonelpoletti.javapostgres.models.User;
import me.glitch.leonelpoletti.javapostgres.models.UserRepository;

import java.util.List;

@RestController
public class UserController {
    @Autowired
    private UserRepository userRepo;
    
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
    public List<User> getUsers() {
        List<User> users = userRepo.findAll();
        return users;
    }
}
