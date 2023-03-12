package com.sha.springbootbootseller.service;

import com.sha.springbootbootseller.model.Role;
import com.sha.springbootbootseller.model.user;
import com.sha.springbootbootseller.repository.IUserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;
import java.util.Optional;
@Service
public class UserService implements IUserService{
    private final IUserRepository userRepository;
    @Autowired
    private PasswordEncoder passwordEncoder;

    public UserService(IUserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public user saveUser(user user) {
                        user.setPassword(passwordEncoder.encode(user.getPassword()));
                        user.setRole(Role.USER);
                        user.setCreateTime(LocalDateTime.now());
                        return userRepository.save(user);

                    }
                    @Override
public Optional<user> findByUsername(String username){
        return userRepository.findByUsername(username);
}
@Override
@Transactional
public void makeAdmin(String username) {
        userRepository.updateUserRole(username, Role.ADMIN);
}
}
