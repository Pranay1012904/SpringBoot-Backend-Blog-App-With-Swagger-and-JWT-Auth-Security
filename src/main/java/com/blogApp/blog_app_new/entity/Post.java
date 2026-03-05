package com.blogApp.blog_app_new.entity;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "Posts")
@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
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
