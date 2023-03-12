package com.sha.springbootbootseller.service;

import com.sha.springbootbootseller.model.user;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

public interface IUserService {
    user saveUser(user user);

    Optional<user> findByUsername(String username);

    @Transactional
    void makeAdmin(String username);
}
