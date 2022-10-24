package com.shson.book.springboot;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;


/*
    SpringBootApplication 어노테이션 역할 : https://seongmun-hong.github.io/springboot/Spring-boot-EnableAutoConfiguration

    스프링 부트의 자동설정, 스프링 Bean 읽기와 생성 모두 자동 생성
    특히 해당 어노테이션이 있는 위치부터 설정을 읽어가기 때문에 , 프로젝트의 최상단에 위치해야 한다!! => 빈을 읽지 못하는 이유 중 하나
 */
@EnableJpaAuditing
@SpringBootApplication
public class Application {
    public static void main(String[] args) {
        SpringApplication.run(Application.class,args);
    }
}
