package com.rubenphi.menu.controllers;

import com.rubenphi.menu.DAO.UserDao;
import com.rubenphi.menu.DTO.CreateUserDto;
import com.rubenphi.menu.models.User;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/users")
public class UsersController {

    @Autowired
    private ModelMapper modelMapper;

    @Autowired
    private UserDao userDao;

    @GetMapping()
    public List<User> getUsers() {
        return userDao.getUsers();
    }

    @GetMapping(path = "/{id}")
    public User getUser(@PathVariable("id") Long id) {
        return userDao.getUser(id);
    }

    @PostMapping()
    public User saveUser(@RequestBody CreateUserDto userRequest) {

        User user = modelMapper.map(userRequest, User.class);
        return userDao.saveUser(user);
    }

    @PutMapping(path = "/{id}")
    public User updateUser(@PathVariable("id") Long id,@RequestBody CreateUserDto userRequest) {

        User user = modelMapper.map(userRequest, User.class);
        user.setId(id);
        user.setCreatedAt(userDao.getUser(id).getCreatedAt());
        return userDao.updateUser(user);
    }

    @DeleteMapping(path = "/{id}")
    public String deleteUser(@PathVariable("id") Long id) {
        boolean elimination = userDao.deleteUser(id);

        if (elimination) {
            return "User with id " + id + " deleted successful";
        } else {
            return "User with id " + id + " don't deleted";
        }

    }


}
