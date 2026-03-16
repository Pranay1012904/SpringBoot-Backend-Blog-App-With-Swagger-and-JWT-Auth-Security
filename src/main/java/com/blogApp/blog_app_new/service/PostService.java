package com.blogApp.blog_app_new.service;

import com.blogApp.blog_app_new.dto.PostDto;
import com.blogApp.blog_app_new.entity.Post;

public interface PostService {

    PostDto createPost(PostDto post);

    PostDto findPostById(Long id);

    PostDto updatePostById(PostDto postDto, Long id);
}
