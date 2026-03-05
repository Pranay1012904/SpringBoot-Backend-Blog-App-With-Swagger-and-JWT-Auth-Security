package com.blogApp.blog_app_new.mapper.postMapper;

import com.blogApp.blog_app_new.dto.PostDto;
import com.blogApp.blog_app_new.entity.Post;
import com.blogApp.blog_app_new.mapper.MapStructConfig;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.springframework.stereotype.Component;

@Mapper(config = MapStructConfig.class, componentModel = "spring")
public interface DtoToEntity {
    @Mapping(source = "id", target = "id")
    @Mapping(source = "title", target = "title")
    @Mapping(source = "description", target = "description")
    @Mapping(source = "content", target = "content")
    Post postDTOToEntity(PostDto post);
}
