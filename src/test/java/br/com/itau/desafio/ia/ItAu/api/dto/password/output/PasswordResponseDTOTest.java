package br.com.itau.desafio.ia.ItAu.api.dto.password.output;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class PasswordResponseDTOTest {

    @Test
    void shouldReturnTrueWhenValidIsTrue() {
        PasswordResponseDTO response = new PasswordResponseDTO(true);
        assertThat(response.valid()).isTrue();
    }

    @Test
    void shouldReturnFalseWhenValidIsFalse() {
        PasswordResponseDTO response = new PasswordResponseDTO(false);
        assertThat(response.valid()).isFalse();
    }

    @Test
    void shouldBeImmutable() {
        PasswordResponseDTO response = new PasswordResponseDTO(true);
        assertThat(response.valid()).isTrue();
        assertThat(!response.valid()).isFalse();
    }
}

