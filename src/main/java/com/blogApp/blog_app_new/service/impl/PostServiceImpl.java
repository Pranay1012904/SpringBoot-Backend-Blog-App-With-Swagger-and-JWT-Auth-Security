package com.blogApp.blog_app_new.service.impl;

import com.blogApp.blog_app_new.dto.PostDto;
import com.blogApp.blog_app_new.entity.Post;
import com.blogApp.blog_app_new.exception.ResourceNotFoundException;
import com.blogApp.blog_app_new.mapper.postMapper.DtoToEntity;
import com.blogApp.blog_app_new.mapper.postMapper.EntityToDto;
import com.blogApp.blog_app_new.repository.PostRepository;
import com.blogApp.blog_app_new.service.PostService;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Slf4j
@Component
@AllArgsConstructor
public class PostServiceImpl implements PostService {

    private PostRepository postRepository;
    private DtoToEntity dtoToEntity;
    private EntityToDto entityToDto;

    @Override
    public PostDto createPost(PostDto post) {
        log.info(String.format("CREATE POST METHOD :: %s", this.getClass().getSimpleName()));
        Post fetchedPost = dtoToEntity.postDTOToEntity(post);
        Optional<Post> savedPost = Optional.ofNullable(postRepository.save(fetchedPost));
        if (savedPost.isEmpty())
            log.error(String.format("Database Error! %s", this.getClass().getSimpleName()));
        return entityToDto.postEntityToDTO(savedPost.get());
    }

    @Override
    public PostDto findPostById(Long id) {
        Post fetchedPost = postRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException(String.format("POST WITH ID %d NOT FOUND", id)));
        return entityToDto.postEntityToDTO(fetchedPost);
    }

    @Override
    public PostDto updatePostById(PostDto postDto, Long id) {
        Post fetchedPost = postRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException(String.format("POST with ID :: %d not found", id)));
        fetchedPost.setContent(postDto.getContent());
        fetchedPost.setTitle(postDto.getTitle());
        fetchedPost.setDescription(postDto.getDescription());
        Post savedPost = postRepository.save(fetchedPost);
        return entityToDto.postEntityToDTO(savedPost);
    }
}
