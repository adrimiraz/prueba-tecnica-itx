package com.prueba.prices.controller;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

import com.prueba.PruitxApplication;

@SpringBootTest(classes = PruitxApplication.class)
@AutoConfigureMockMvc
public class PriceControllerTest {

	@Autowired
    private MockMvc mockMvc;

	// Test 1: 14 de junio a las 10:00h → priceList 1
    @Test
    @DisplayName("Test 1 - 14/06/2020 10:00 - priceList 1")
    void test1() throws Exception {
        mockMvc.perform(get("/api/prices")
                        .param("date", "2020-06-14T10:00:00")
                        .param("productId", "35455")
                        .param("brandId", "1"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.priceList").value(1));
    }

    // Test 2: 14 de junio a las 16:00h → priceList 2
    @Test
    @DisplayName("Test 2 - 14/06/2020 16:00 - priceList 2")
    void test2() throws Exception {
        mockMvc.perform(get("/api/prices")
                        .param("date", "2020-06-14T16:00:00")
                        .param("productId", "35455")
                        .param("brandId", "1"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.priceList").value(2));
    }

    // Test 3: 14 de junio a las 21:00h → priceList 1
    @Test
    @DisplayName("Test 3 - 14/06/2020 21:00 - priceList 1")
    void test3() throws Exception {
        mockMvc.perform(get("/api/prices")
                        .param("date", "2020-06-14T21:00:00")
                        .param("productId", "35455")
                        .param("brandId", "1"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.priceList").value(1));
    }

    // Test 4: 15 de junio a las 10:00h → priceList 3
    @Test
    @DisplayName("Test 4 - 15/06/2020 10:00 - priceList 3")
    void test4() throws Exception {
        mockMvc.perform(get("/api/prices")
                        .param("date", "2020-06-15T10:00:00")
                        .param("productId", "35455")
                        .param("brandId", "1"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.priceList").value(3));
    }

    // Test 5: 16 de junio a las 21:00h → priceList 4
    @Test
    @DisplayName("Test 5 - 16/06/2020 21:00 - priceList 4")
    void test5() throws Exception {
        mockMvc.perform(get("/api/prices")
                        .param("date", "2020-06-16T21:00:00")
                        .param("productId", "35455")
                        .param("brandId", "1"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.priceList").value(4));
    }
	
}
