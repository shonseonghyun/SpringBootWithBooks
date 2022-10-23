package com.shson.book.springboot.web;

import com.shson.book.springboot.domain.posts.Posts;
import com.shson.book.springboot.domain.posts.PostsRepository;
import com.shson.book.springboot.service.posts.PostsService;
import com.shson.book.springboot.web.dto.PostsSaveRequestDTO;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.test.web.server.LocalServerPort;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.web.client.RestTemplate;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

import static org.junit.jupiter.api.Assertions.*;

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
class PostsApiControllerTest {

    @LocalServerPort
    private int port;

    @Autowired
    private TestRestTemplate restTemplate;

    @Autowired
    public PostsRepository postsRepository;

    /*
        PostsService, PostsAipController 검증
    */

    @Test
    public void Posts_등록테스트(){

        //given

        //Post요청 url
        String url = "http://localhost:"+port+"/api/v1/posts";

        String title= "testTitle";
        String content= "testContent";
        String author= "testAuthor";
        PostsSaveRequestDTO requestDTO = PostsSaveRequestDTO.builder()
                .title(title)
                .content(content)
                .author(author)
                .build();

        //when
        ResponseEntity<Long> responseEntity  = restTemplate.postForEntity(url ,requestDTO.toEntity(), Long.class);

        //then
        assertThat(responseEntity.getStatusCode()).isEqualTo(HttpStatus.OK);
        assertThat(responseEntity.getBody()).isGreaterThan(0L);

        List<Posts> all = postsRepository.findAll();
        assertThat(all.get(0).getTitle()).isEqualTo(title);
        assertThat(all.get(0).getAuthor()).isEqualTo(author);
        assertThat(all.get(0).getContent()).isEqualTo(content);
    }

}