package com.sha.springbootbootseller.repository;

import com.sha.springbootbootseller.model.Role;
import com.sha.springbootbootseller.model.user;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.Optional;

public interface IUserRepository extends JpaRepository <user, Long> {
    Optional<user> findByUsername(String username);
    @Modifying
    @Query("update user set role = :role where username = :username")
    void updateUserRole(@Param("username") String username, @Param("role") Role role);

}
