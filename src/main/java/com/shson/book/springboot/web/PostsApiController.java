package com.shson.book.springboot.web;

import com.shson.book.springboot.service.posts.PostsService;
import com.shson.book.springboot.web.dto.PostsResponseDTO;
import com.shson.book.springboot.web.dto.PostsSaveRequestDTO;
import com.shson.book.springboot.web.dto.PostsUpdateRequestDTO;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RequiredArgsConstructor
@RestController
public class PostsApiController {

    private final PostsService postsService;

    //글 작성
    @PostMapping("/api/v1/posts")
    public Long save(@RequestBody PostsSaveRequestDTO requestDTO){
        return postsService.save(requestDTO);
    }

    //수정
    @PutMapping("/api/v1/posts/{id}")
    public Long update(@PathVariable("id") Long id , @RequestBody PostsUpdateRequestDTO requestDTO){
        return postsService.update(id,requestDTO);
    }

    //조회
    @GetMapping("/api/vi/posts/{id}")
    public PostsResponseDTO findByid(@PathVariable("id") Long id){
        return postsService.findById(id);
    }
}
