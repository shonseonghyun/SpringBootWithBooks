package com.shson.book.springboot.service.posts;

import com.shson.book.springboot.domain.posts.PostsRepository;
import com.shson.book.springboot.web.dto.PostsSaveRequestDTO;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


@RequiredArgsConstructor //final이 선언된 모든 필드를 인자값으로 생성
@Service
public class PostsService {

   private final PostsRepository postsRepository;

   @Transactional
    public Long save(PostsSaveRequestDTO requestDTO){
        return postsRepository.save(requestDTO.toEntity()).getId();
    }
}
