package com.blogApp.blog_app_new.controller;

import com.blogApp.blog_app_new.dto.PostDto;
import com.blogApp.blog_app_new.service.PostService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@RestController
@AllArgsConstructor
@RequestMapping("/post/v1")
public class PostController {
    private PostService postService;

    @PostMapping("/create")
    public ResponseEntity<PostDto> createPost(@RequestBody PostDto post) {
        return new ResponseEntity<>(postService.createPost(post), HttpStatus.CREATED);
    }

    @GetMapping("/getPost")
    public ResponseEntity<PostDto> getPost(@RequestParam Long id) {
        PostDto fetchedPost = postService.findPostById(id);
        return new ResponseEntity<>(fetchedPost, HttpStatus.FOUND);
    }

    @PutMapping("/updatePost/{id}")
    public ResponseEntity<PostDto> updatePost(@RequestBody PostDto postDto, @PathVariable(name = "id") Long id) {
        PostDto updatedPost = postService.updatePostById(postDto, id);
        return new ResponseEntity<>(updatedPost, HttpStatus.OK);
    }
    @DeleteMapping("/deletePost/{id}")
    public ResponseEntity<String> deletePost(@PathVariable Long id){
        postService.deletePostById(id);
        return new ResponseEntity<>(String.format("POST WITH ID %s deleted",id),HttpStatus.OK);
    }
}
