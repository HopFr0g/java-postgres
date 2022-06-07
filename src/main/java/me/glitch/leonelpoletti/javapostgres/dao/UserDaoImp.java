package me.glitch.leonelpoletti.javapostgres.dao;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import me.glitch.leonelpoletti.javapostgres.models.User;

@Repository
@Transactional
public class UserDaoImp implements UserDao {
    // Used in .getUsers() to avoid errors with the List<User> return:
    private static <T> List<T> castList(Class<? extends T> clazz, Collection<?> c) {
        List<T> r = new ArrayList<T>(c.size());
        for(Object o: c)
          r.add(clazz.cast(o));
        return r;
    }
    
    @PersistenceContext
    private EntityManager entityManager;
    
    @Override
    public List<User> getUsers() {
        String query = "from User";
        return castList(User.class, entityManager.createQuery(query).getResultList());
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