package com.example.plombing.global.repository;

import com.example.plombing.domain.post.entity.Post;
import com.example.plombing.global.entity.User;
import com.example.plombing.global.entity.UserType;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {
    User findByUserType(UserType anonymity);
}
