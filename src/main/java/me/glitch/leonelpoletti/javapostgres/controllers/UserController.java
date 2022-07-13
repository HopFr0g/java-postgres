package me.glitch.leonelpoletti.javapostgres.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
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
    
    @RequestMapping(value = "users/{id}", method = RequestMethod.DELETE)
    public void deleteUser(@PathVariable Integer id) {
        userDao.deleteUser(id);
    }
    
    @RequestMapping(value = "users", method = RequestMethod.POST)
    public void addUser(@RequestBody User user) {
        userDao.addUser(user);
    }
    
    @RequestMapping(value = "consumirrest", method = RequestMethod.GET)
    public void consumirRest() {
        userDao.consumirRest();
    }
}
