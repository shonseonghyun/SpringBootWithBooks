package com.shson.book.springboot.web.dto;

import com.shson.book.springboot.domain.posts.Posts;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;


/*
    Posts 엔티티와 유사하지만 DTO추가 생성
    why? 엔티티 클래스는 DB와 맞닿은 핵심 클래스이기 때문 , DTO는 뷰를 위한 클래스라 자주 변경될 가능성이 존재
*/
@Getter
@NoArgsConstructor
public class PostsSaveRequestDTO {

    String title;
    String author;
    String content;

    @Builder
    public PostsSaveRequestDTO(String title, String author, String content) {
        this.title = title;
        this.author = author;
        this.content = content;
    }

    public Posts toEntity(){
        return Posts.builder()
                .title(title)
                .author(author)
                .content(content)
                .build();
    }

}
