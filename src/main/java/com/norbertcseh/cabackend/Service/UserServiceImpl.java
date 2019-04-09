package com.norbertcseh.cabackend.Service;

import java.util.List;

import com.norbertcseh.cabackend.Entity.User;
import com.norbertcseh.cabackend.Repository.UserRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {

    private UserRepository userRepo;

    @Autowired
    public void setUserRepo(UserRepository userRepo) {
        this.userRepo = userRepo;
    }

    @Override
    public User registerUser(User user) {
        // Ide még kurvára kéne valami setUser stb...
        return user;
    }

    @Override
    public User findByEmail(String email) {
        return userRepo.findByEmail(email);
    }

    @Override
    public User findByFullName(String fullName) {
        return userRepo.findByFullName(fullName);
    }

    @Override
    public User findByHandle(String handle) {
        return userRepo.findByHandle(handle);
    }

    @Override
    public List<User> findAll() {
        return userRepo.findAll();
    }

    @Override
    public User save(User user) {
        return userRepo.save(user);
    }

    public User deleteUserByHandle(String handle) {
        return userRepo.deleteUserByHandle(handle);
    }

}