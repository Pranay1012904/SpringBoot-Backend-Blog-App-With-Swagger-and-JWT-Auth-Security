package com.blogApp.blog_app_new.repository;

import com.blogApp.blog_app_new.entity.Post;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PostRepository extends JpaRepository<Post, Long> {
}
