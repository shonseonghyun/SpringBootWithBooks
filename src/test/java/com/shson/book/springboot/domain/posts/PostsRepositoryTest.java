package com.shson.book.springboot.domain.posts;

import org.junit.After;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.event.annotation.AfterTestClass;
import org.springframework.test.context.junit4.SpringRunner;
import static org.assertj.core.api.Assertions.assertThat;


import javax.swing.*;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@RunWith(SpringRunner.class)
@SpringBootTest
class PostsRepositoryTest {

    @Autowired
    PostsRepository postsRepository;


    @AfterEach
    public void 전체삭제(){
        postsRepository.deleteAll();
//        postsRepository.deleteById(0L);
    }


    @Test
    public void 게시글저장(){

        //given
        String title = "타이틀test";
        String content = "컨텐트test";
        String author = "손성현test@naver.com";

        postsRepository.save(Posts.builder()
                .title(title)
                .content(content)
                .author(author).build());


        //when
        List<Posts> postsList = postsRepository.findAll();

        //then
        Posts p = postsList.get(0);
        assertThat(p.getTitle()).isEqualTo(title);
        assertThat(p.getContent()).isEqualTo(content);
        assertThat(p.getAuthor()).isEqualTo(author);
    }



}