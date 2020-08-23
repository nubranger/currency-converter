package com.example.currencyconverter.controllers;

import com.example.currencyconverter.services.CurrencyService;
import com.example.currencyconverter.services.UserLoggingService;
import com.example.currencyconverter.services.XMLService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.ui.Model;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@ExtendWith(MockitoExtension.class)
class CurrencyControllerTest {

    @Mock
    XMLService xmlService;

    @Mock
    CurrencyService currencyService;

    @Mock
    UserLoggingService userLoggingService;

    @Mock
    Model model;

    @InjectMocks
    CurrencyController currencyController;

    MockMvc mockMvc;

    @BeforeEach
    void setUp() {

        mockMvc = MockMvcBuilders.standaloneSetup(currencyController).build();
    }

    @Test
    void getIndex() throws Exception {

        mockMvc.perform(get("/"))
                .andExpect(status().isOk())
                .andExpect(model().attributeExists("currencyRate"))
                .andExpect(model().attributeExists("currencyMap"))
                .andExpect(model().attributeExists("amount"))
                .andExpect(model().attributeExists("selectedCurrencyCode"))
                .andExpect(view().name("index"));
    }
}