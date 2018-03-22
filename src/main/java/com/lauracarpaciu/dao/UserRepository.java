package com.lauracarpaciu.dao;

import com.lauracarpaciu.entities.user.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;

public interface UserRepository extends JpaRepository<User,String>{
    User findUserByUsername(@Param("username") String username);
}
