package com.norbertcseh.cabackend.Repository;

import java.util.List;

import com.norbertcseh.cabackend.Entity.User;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {

    User findByFullName(String fullName);

    User findByHandle(String handle);

    User findByEmail(String email);

    List<User> findAll();

    User deleteUserByHandle(String handle);

}