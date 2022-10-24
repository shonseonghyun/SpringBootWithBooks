package com.shson.book.springboot.service.posts;

import com.shson.book.springboot.domain.posts.Posts;
import com.shson.book.springboot.domain.posts.PostsRepository;
import com.shson.book.springboot.web.dto.PostsResponseDTO;
import com.shson.book.springboot.web.dto.PostsSaveRequestDTO;
import com.shson.book.springboot.web.dto.PostsUpdateRequestDTO;
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

    @Transactional
    public Long update(Long id, PostsUpdateRequestDTO requestDTO) {
       Posts posts = postsRepository.findById(id)
               .orElseThrow(() -> new IllegalArgumentException("해당 게시글이 없습니다. id="+id ));
       posts.update(requestDTO.getTitle(),requestDTO.getContent());

       return id;
    }

    public PostsResponseDTO findById(Long id){
       Posts posts =postsRepository.findById(id)
               .orElseThrow(()-> new IllegalArgumentException("해당 게시글이 없습니다. id="+id));

       return new PostsResponseDTO(posts);

    }



}
