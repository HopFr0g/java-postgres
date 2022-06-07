package me.glitch.leonelpoletti.javapostgres.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import me.glitch.leonelpoletti.javapostgres.libs.ListCaster;
import me.glitch.leonelpoletti.javapostgres.models.User;

@Repository
@Transactional
public class UserDaoImp implements UserDao {
    @PersistenceContext
    private EntityManager entityManager;
    
    @Override
    public List<User> getUsers() {
        String query = "from User";
        return ListCaster.castList(User.class, entityManager.createQuery(query).getResultList());
    }

    @Override
    public void deleteUser(Integer id) {
        User user = entityManager.find(User.class, id);
        entityManager.remove(user);
    }

    @Override
    public void addUser(User user) {
        entityManager.merge(user);
    }
}