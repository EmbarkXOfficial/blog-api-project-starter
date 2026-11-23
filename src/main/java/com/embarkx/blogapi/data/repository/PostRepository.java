package com.embarkx.blogapi.data.repository;

import com.embarkx.blogapi.data.entity.Post;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PostRepository extends JpaRepository<Post, Integer> {
}