package com.rubenphi.menu.DAO;

import com.rubenphi.menu.models.User;

import java.util.List;

public interface UserDao {

    List<User> getUsers();
    User saveUser(User user);

    User updateUser(User user);

    User getUser(Long id);
    boolean deleteUser(Long id);


}
