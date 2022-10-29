package com.shson.book.springboot.web.dto;


import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;


class HelloResponseDtoTest {

    @Test
    public void lomkboktest(){
        String name = "test";
        int amount =1000;

        HelloResponseDTO dto = new HelloResponseDTO(name,amount);



        assertThat(dto.getName()).isEqualTo(name);
        assertThat(dto.getAmount()).isEqualTo(amount);

    }
}