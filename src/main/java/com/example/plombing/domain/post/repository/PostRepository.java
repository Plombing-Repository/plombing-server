package com.example.plombing.domain.post.repository;

import com.example.plombing.domain.post.entity.Post;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface PostRepository extends JpaRepository<Post, Long> {
    List<Post> findByPostTitleContaining(String search);

    List<Post> findByPostContaining(String search);
}
