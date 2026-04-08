package br.com.itau.desafio.ia.ItAu.api.dto.password.input;

import jakarta.validation.ConstraintViolation;
import jakarta.validation.Validation;
import jakarta.validation.Validator;
import jakarta.validation.ValidatorFactory;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.util.Set;

import static org.assertj.core.api.Assertions.assertThat;

class PasswordRequestDTOTest {

    private static Validator validator;

    @BeforeAll
    static void setupValidator() {
        ValidatorFactory factory = Validation.buildDefaultValidatorFactory();
        validator = factory.getValidator();
    }

    @Test
    void shouldPassValidationWhenPasswordIsValid() {
        PasswordRequestDTO dto = new PasswordRequestDTO("Abcdef1@3");

        Set<ConstraintViolation<PasswordRequestDTO>> violations = validator.validate(dto);

        assertThat(violations).isEmpty();
    }

    @Test
    void shouldFailValidationWhenPasswordIsNull() {
        PasswordRequestDTO dto = new PasswordRequestDTO(null);

        Set<ConstraintViolation<PasswordRequestDTO>> violations = validator.validate(dto);

        assertThat(violations).isNotEmpty();
        assertThat(violations.iterator().next().getMessage())
                .isEqualTo("o campo 'password' deve ser informado");
    }

    @Test
    void shouldFailValidationWhenPasswordIsBlank() {
        PasswordRequestDTO dto = new PasswordRequestDTO("   ");

        Set<ConstraintViolation<PasswordRequestDTO>> violations = validator.validate(dto);

        assertThat(violations).isNotEmpty();
        assertThat(violations.iterator().next().getMessage())
                .isEqualTo("o campo 'password' deve ser informado");
    }
}

