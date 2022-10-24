package com.shson.book.springboot.web;

import com.shson.book.springboot.domain.posts.Posts;
import com.shson.book.springboot.domain.posts.PostsRepository;
import com.shson.book.springboot.service.posts.PostsService;
import com.shson.book.springboot.web.dto.PostsSaveRequestDTO;
import com.shson.book.springboot.web.dto.PostsUpdateRequestDTO;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.test.web.server.LocalServerPort;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
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

    @AfterEach
    public void 삭제(){
        postsRepository.deleteAll();
    }

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

    @Test
    public void Posts_수정테스트(){
        //given
        //org
        String author = "shson";
        String org_title = "org_title";
        String org_content= "org_content";
        Posts posts = postsRepository.save(Posts.builder()
                                            .title(org_title)
                                            .content(org_content)
                                            .author(author)
                                            .build()
        );

        //updated
        String expectedTitle = "newtitle";
        String expectedContent = "newcontent";
        PostsUpdateRequestDTO requestDTO = PostsUpdateRequestDTO
                .builder()
                .title(expectedTitle)
                .content(expectedContent)
                .build();

        String url = "http://localhost:"+port+"/api/v1/posts/"+posts.getId();
        HttpEntity<PostsUpdateRequestDTO> entity = new HttpEntity<>(requestDTO);

        //when
        ResponseEntity<Long> responseEntity  = restTemplate.exchange(url, HttpMethod.PUT,entity,Long.class);


        //then
        assertThat(responseEntity.getStatusCode()).isEqualTo(HttpStatus.OK);
        assertThat(responseEntity.getBody()).isGreaterThan(0L);

        List<Posts> all = postsRepository.findAll();
        Posts posts1 = all.get(0);
        assertThat(posts1.getTitle()).isEqualTo(expectedTitle);
        assertThat(posts1.getContent()).isEqualTo(expectedContent);
    }
}