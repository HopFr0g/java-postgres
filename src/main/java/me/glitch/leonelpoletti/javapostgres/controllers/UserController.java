package me.glitch.leonelpoletti.javapostgres.controllers;

import org.apache.tomcat.util.http.parser.MediaType;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.data.jpa.provider.HibernateUtils;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.databind.ObjectMapper;

import me.glitch.leonelpoletti.javapostgres.models.User;
import me.glitch.leonelpoletti.javapostgres.models.UserRepository;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;

@RestController
public class UserController {
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
}
