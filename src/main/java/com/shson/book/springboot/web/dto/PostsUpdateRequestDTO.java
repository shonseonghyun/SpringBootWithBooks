package com.shson.book.springboot.web.dto;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
public class PostsUpdateRequestDTO {
    String title;
    String content;


    @Builder
    public PostsUpdateRequestDTO(String title, String content){
        this.title=title;
        this.content= content;
    }
}
