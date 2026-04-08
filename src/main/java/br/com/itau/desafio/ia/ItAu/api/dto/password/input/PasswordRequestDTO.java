package br.com.itau.desafio.ia.ItAu.api.dto.password.input;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public record PasswordRequestDTO(

        @NotNull(message = "o campo 'password' deve ser informado") 
        @NotBlank(message = "o campo 'password' deve ser informado") 
        String password) {
}
