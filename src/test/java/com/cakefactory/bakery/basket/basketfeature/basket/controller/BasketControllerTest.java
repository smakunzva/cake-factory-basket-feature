package com.cakefactory.bakery.basket.basketfeature.basket.controller;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import java.util.UUID;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
class BasketControllerTest {

    @Autowired
    private MockMvc mockmvc;

    @Test
    public void addItem() throws Exception {

        String valuesData = "{\"name\" : \"test1\", \"costs\" : \"23.78\" }";

        mockmvc.perform(post("/basket/add/item")
                .contentType(MediaType.APPLICATION_JSON_VALUE)
        .content(valuesData)
        .header("sessionId", UUID.randomUUID().toString()))
        .andExpect(status().isOk());
    }

    @Test
    public void addItems() {
    }

    @Test
    public void removeItem() {
    }

    @Test
    public void removeItems() {
    }
}