package br.com.itau.desafio.ia.ItAu.domain.validator;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest
class ValidationRuleTest {

    @Test
    void shouldReturnTrueForCustomRule() {
        ValidationRule rule = password -> password != null && password.equals("segredo");

        boolean result = rule.isValid("segredo");

        assertThat(result).isTrue();
    }

    @Test
    void shouldReturnFalseForCustomRule() {
        ValidationRule rule = password -> password != null && password.equals("segredo");

        boolean result = rule.isValid("errado");

        assertThat(result).isFalse();
    }

    @Test
    void shouldHandleNullPassword() {
        ValidationRule rule = password -> password != null && password.length() > 5;
        boolean result = rule.isValid(null);
        assertThat(result).isFalse();
    }

    @Test
    void shouldWorkWithDifferentImplementations() {
        ValidationRule lengthRule = password -> password != null && password.length() >= 8;
        ValidationRule digitRule = password -> password != null && password.chars().anyMatch(Character::isDigit);

        assertThat(lengthRule.isValid("12345678")).isTrue();
        assertThat(digitRule.isValid("abcdef")).isFalse();
    }
}

