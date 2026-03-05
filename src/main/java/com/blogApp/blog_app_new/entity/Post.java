package com.blogApp.blog_app_new.entity;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Table(name = "Posts")
@Data
public class Post {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(nullable = false)
    private String title;
    @Column(nullable = false)
    private  String description;
    @Column(nullable = false)
    private String content;
}
