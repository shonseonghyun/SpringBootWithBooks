package com.shson.book.springboot.web.dto;

import com.shson.book.springboot.domain.posts.Posts;
import lombok.Getter;

import java.time.LocalDateTime;

@Getter
public class PostsListResponseDTO {
    private Long id;
    private String title;
    private String author;
    private LocalDateTime modifiedDate;

    public PostsListResponseDTO(Posts entity){
        id = entity.getId();
        title = entity.getTitle();
        author= entity.getAuthor();
        modifiedDate = entity.getModifiedDate();
    }
}
