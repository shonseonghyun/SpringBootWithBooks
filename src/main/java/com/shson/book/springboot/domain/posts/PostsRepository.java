package com.shson.book.springboot.domain.posts;

import org.springframework.data.jpa.repository.JpaRepository;

/*
    JpaRepository<Entity 클래스 ,PK타입>
    Entity 클래스와 EntityRepository는 함께 위치해야 한다.(같은 패키지에 존재)
 */

public interface PostsRepository extends JpaRepository<Posts,Long> {
}
