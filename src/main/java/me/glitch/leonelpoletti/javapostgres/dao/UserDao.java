package me.glitch.leonelpoletti.javapostgres.dao;

import me.glitch.leonelpoletti.javapostgres.models.User;

import java.util.List;

public interface UserDao {
    List<User> getUsers();
    void deleteUser(Integer id);
    void addUser(User user);
}