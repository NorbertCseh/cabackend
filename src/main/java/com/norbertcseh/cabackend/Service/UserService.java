package com.norbertcseh.cabackend.Service;

import java.util.List;

import com.norbertcseh.cabackend.Entity.User;

public interface UserService {

    public User registerUser(User user);

    public User findByEmail(String email);

    public User findByFullName(String fullName);

    public User findByHandle(String handle);

    public List<User> findAll();

    public User save(User user);

    public User deleteUserByHandle(String handle);

}