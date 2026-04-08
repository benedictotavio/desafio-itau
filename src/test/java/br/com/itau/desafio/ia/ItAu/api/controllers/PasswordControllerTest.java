package br.com.itau.desafio.ia.ItAu.api.controllers;

import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.webmvc.test.autoconfigure.WebMvcTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.bean.override.mockito.MockitoBean;
import org.springframework.test.web.servlet.MockMvc;

import br.com.itau.desafio.ia.ItAu.api.controller.PasswordController;
import br.com.itau.desafio.ia.ItAu.application.service.PasswordService;

import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@WebMvcTest(PasswordController.class)
class PasswordControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockitoBean
    private PasswordService passwordService;

    @Test
    void shouldReturnValidTrueWhenPasswordIsStrong() throws Exception {
        when(passwordService.validate("Abcdef1@3")).thenReturn(true);

        String requestJson = "{\"password\":\"Abcdef1@3\"}";

        mockMvc.perform(post("/password/validate")
                .contentType(MediaType.APPLICATION_JSON)
                .content(requestJson))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.valid").value(true));
    }

    @Test
    void shouldReturnValidFalseWhenPasswordIsWeak() throws Exception {
        when(passwordService.validate("abc")).thenReturn(false);

        String requestJson = "{\"password\":\"abc\"}";

        mockMvc.perform(post("/password/validate")
                .contentType(MediaType.APPLICATION_JSON)
                .content(requestJson))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.valid").value(false));
    }

    @Test
    void shouldReturnValidFalseWhenPasswordIsNull() throws Exception {
        when(passwordService.validate(null)).thenReturn(false);

        String requestJson = "{\"password\":null}";

        mockMvc.perform(post("/password/validate")
                .contentType(MediaType.APPLICATION_JSON)
                .content(requestJson))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.valid").value(false));
    }
}