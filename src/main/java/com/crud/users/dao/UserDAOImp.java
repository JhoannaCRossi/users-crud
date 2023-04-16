package com.crud.users.dao;

import com.crud.users.models.User;


import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
@Repository
@Transactional
public class UserDAOImp implements IUserDAO {
    @PersistenceContext
    EntityManager entityManager;

    @Override
    @Transactional
    public List<User> getUsers() {
        String query = "From User";
        return entityManager.createQuery(query).getResultList();

    }

    @Override
    public void deleteUser(Long id) {
        User user = entityManager.find(User.class,id);
        entityManager.remove(user);
    }

    @Override
    public void registerUser(User user) {
        entityManager.merge(user);
    }

    @Override
    public boolean checkUser(User user) {
        String query = "FROM User WHERE email = :email AND password = :password";
        List<User> users = entityManager.createQuery(query)
                .setParameter("email", user.getEmail())
                .setParameter("password", user.getPassword())
                .getResultList();
        return !users.isEmpty();
    }

}
