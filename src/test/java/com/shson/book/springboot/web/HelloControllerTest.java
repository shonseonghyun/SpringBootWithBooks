package com.shson.book.springboot.web;

import org.junit.jupiter.api.Test;
import static org.hamcrest.Matchers.is;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import static org.junit.jupiter.api.Assertions.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

/*
    반드시 실제 구현 클래스와 동일한 경로에 위치하도록 해야한다.
 */

@RunWith(SpringRunner.class) //Junit4에서만 지원 , Junit5에선 ExtendWith으로 대체
@WebMvcTest(controllers = HelloController.class)
class HelloControllerTest {

    @Autowired
    private MockMvc mvc;

    @Test
    void hello_리턴() throws Exception {

        mvc.perform(get("/hello"))
                .andExpect(status().isOk())
                .andExpect(content().string("hello"));
    }

    @Test
    void helloDto_리턴() throws Exception {

        String name ="nametest";
        int amount =1000;

        mvc.perform(get("/hello/dto")
                        .param("name",name)
                        .param("amount",String.valueOf(amount))
                )
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.name",is(name)))
                .andExpect(jsonPath("$.amount",is(amount)));
    }
}