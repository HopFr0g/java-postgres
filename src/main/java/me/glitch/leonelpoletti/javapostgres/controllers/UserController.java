package me.glitch.leonelpoletti.javapostgres.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import me.glitch.leonelpoletti.javapostgres.dao.UserDao;
import me.glitch.leonelpoletti.javapostgres.models.User;

import java.util.List;

@RestController
public class UserController implements UserDao{
    @Autowired
    private UserDao userDao;
    
    @RequestMapping(value = "users", method = RequestMethod.GET)
    public List<User> getUsers() {
        return userDao.getUsers();
    }
}





/*
    @Autowired
    private UserRepository userRepo;
    
    @Transactional
    public void insertar(String json) throws Exception {
        ObjectMapper objectMapper = new ObjectMapper();
        User user = objectMapper.readValue(json, User.class);
        
        System.out.println(user.toString()); // TODO
    }
    
    // Create:
    @RequestMapping(value = "users/add", method = RequestMethod.POST, consumes = "application/json", produces = "application/json")
    public void getJson(HttpEntity<String> httpEntity) {
        String json = httpEntity.getBody();
        
        try {
            System.out.println(json); // TODO
            insertar(json);
        } catch (Exception e) {
            System.out.print("ERROR: ");
            System.out.print(e);
        }
    }
    
    // Create:
    // @RequestMapping(value = "users/add", method = RequestMethod.POST)
    // public void createUser(User user) {
    //     System.out.println(user.toString());
    // }
    
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
    */