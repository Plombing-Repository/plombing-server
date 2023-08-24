package com.example.plombing.domain.post.repository;

import com.example.plombing.domain.post.entity.Comment;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface CommentRepository extends JpaRepository<Comment, Long> {
    Optional<Comment> findByCommentIndexAndPassword(Long commentIndex, String password);
}
