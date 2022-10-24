package com.shson.book.springboot.domain.posts;

import com.shson.book.springboot.service.posts.PostsService;
import com.shson.book.springboot.web.dto.PostsUpdateRequestDTO;
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

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;

@RunWith(SpringRunner.class)
@SpringBootTest
class PostsRepositoryTest {

    @Autowired
    PostsRepository postsRepository;

    @Autowired
    PostsService postsService;


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

    @Test
    public void BaseTimeEntity_테스트() throws InterruptedException {
        //현재시간
        LocalDateTime now = LocalDateTime.now();

        //create
        postsRepository.save(Posts.builder().title("title").content("contetn").author("author").build());

        List<Posts> postsList = postsRepository.findAll();
        Posts posts = postsList.get(0);

        //update
        postsService.update(posts.getId(), PostsUpdateRequestDTO.builder().title("t").content("s").build());

        //insert 시점
        System.out.println("now: "+now + "/create : "+posts.getCreatedDate());
        assertThat(posts.getCreatedDate()).isAfter(now);

        //update 시점
        System.out.println("now: "+now + "/modified : "+posts.getModifiedDate());
        assertThat(posts.getModifiedDate()).isAfter(now);

    }



}