package me.glitch.leonelpoletti.javapostgres.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import me.glitch.leonelpoletti.javapostgres.models.User;

@Repository
@Transactional
public class UserDaoImp implements UserDao {
    
    @PersistenceContext
    private EntityManager entityManager;
    
    @Override
    public List<User> getUsers() {
        String query = "from User";
        return entityManager.createQuery(query).getResultList();
    }
}
