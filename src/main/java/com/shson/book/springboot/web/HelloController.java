package com.shson.book.springboot.web;

import com.shson.book.springboot.web.dto.HelloResponseDTO;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

    @RestController
    public class HelloController {
        private final Logger logger= LoggerFactory.getLogger(com.shson.book.springboot.web.HelloController.class);

        @GetMapping("/hello")
        public String hello(){
            logger.trace("trace");
            logger.info("info");
            logger.debug("debug");
            logger.warn("warn");
            logger.error("error");
            return "hello";
        }

        @GetMapping("hello/dto")
    public HelloResponseDTO helloDto(@RequestParam("name") String name , @RequestParam("amount") int amount){

        return new HelloResponseDTO(name,amount);
        /*출력값 아래와 같다.
            {"name":"asd","amount":2}
        */
    }
}
