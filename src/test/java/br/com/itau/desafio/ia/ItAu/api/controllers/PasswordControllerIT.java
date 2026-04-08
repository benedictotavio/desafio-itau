package br.com.itau.desafio.ia.ItAu.api.controllers;

import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.webmvc.test.autoconfigure.AutoConfigureMockMvc;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

@AutoConfigureMockMvc
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
class PasswordControllerIT {

    private static final String VALIDATE = "/password/validate";

    @Autowired
    MockMvc mockMvc;

    @Test
    void shouldReturnValidTrueWhenPasswordIsStrong() throws Exception {
        String requestJson = "{\"password\":\"Abcdef1@3\"}";

        mockMvc.perform(MockMvcRequestBuilders.post(VALIDATE)
                .contentType(MediaType.APPLICATION_JSON)
                .content(requestJson))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.valid").value(true));
    }

    @Test
    void shouldReturnValidFalseWhenPasswordIsWeak() throws Exception {
        String requestJson = "{\"password\":\"abc\"}";

        mockMvc.perform(MockMvcRequestBuilders.post(VALIDATE)
                .contentType(MediaType.APPLICATION_JSON)
                .content(requestJson))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.valid").value(false));
    }

    @Test
    void shouldReturnValidFalseWhenPasswordIsNull() throws Exception {
        String requestJson = "{\"password\":null}";

        mockMvc.perform(MockMvcRequestBuilders.post(VALIDATE)
                .contentType(MediaType.APPLICATION_JSON)
                .content(requestJson))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.valid").value(false));
    }
}