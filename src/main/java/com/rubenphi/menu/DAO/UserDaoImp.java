package com.rubenphi.menu.DAO;


import com.rubenphi.menu.models.User;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

@Repository
@Transactional
public class UserDaoImp implements UserDao {
    @PersistenceContext
    EntityManager entityManager;

    @Override
    public List<User> getUsers() {
        String query = "FROM User";
        return entityManager.createQuery(query).getResultList();

    }

    @Override
    public User saveUser(User user) {
        return entityManager.merge(user);
    }

    @Override
    public User getUser(Long id) {
        User user = entityManager.find(User.class, id);
        return user;
    }

    @Override
    public boolean deleteUser(Long id) {
        try {
            User user = entityManager.find(User.class, id);
            entityManager.remove(user);
            return true;
        } catch (Exception error) {
            return false;
        }
    }
}
