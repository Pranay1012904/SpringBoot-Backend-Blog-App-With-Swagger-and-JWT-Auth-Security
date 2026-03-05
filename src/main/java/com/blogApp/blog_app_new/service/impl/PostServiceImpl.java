package com.blogApp.blog_app_new.service.impl;

import com.blogApp.blog_app_new.dto.PostDto;
import com.blogApp.blog_app_new.entity.Post;
import com.blogApp.blog_app_new.mapper.postMapper.DtoToEntity;
import com.blogApp.blog_app_new.mapper.postMapper.EntityToDto;
import com.blogApp.blog_app_new.repository.PostRepository;
import com.blogApp.blog_app_new.service.PostService;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Slf4j
@Component
public class PostServiceImpl implements PostService {

    private PostRepository postRepository;
    private DtoToEntity dtoToEntity;
    private EntityToDto entityToDto;

    public PostServiceImpl(PostRepository postRepository, DtoToEntity dtoToEntity, EntityToDto entityToDto) {
        this.postRepository = postRepository;
        this.dtoToEntity = dtoToEntity;
        this.entityToDto = entityToDto;
    }

    @Override
    public PostDto createPost(PostDto post) {
        log.info(String.format("CREATE POST METHOD :: %s", this.getClass().getSimpleName()));
        Post fetchedPost=dtoToEntity.postDTOToEntity(post);
        Optional<Post> savedPost = Optional.ofNullable(postRepository.save(fetchedPost));
        if (savedPost.isEmpty()) {
            log.error(String.format("Database Error! %s", this.getClass().getSimpleName()));
        }
        return entityToDto.postEntityToDTO(savedPost.get());
    }
}
