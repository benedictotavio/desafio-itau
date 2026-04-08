package br.com.itau.desafio.ia.ItAu.application.service;

import br.com.itau.desafio.ia.ItAu.domain.validator.ValidationRule;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

class PasswordServiceTest {

    @Test
    void shouldReturnTrueWhenAllRulesPass() {
        ValidationRule alwaysTrueRule = password -> true;
        ValidationRule anotherTrueRule = password -> password.length() > 0;

        PasswordService service = new PasswordService(List.of(alwaysTrueRule, anotherTrueRule));

        boolean result = service.validate("Abc123@");

        assertThat(result).isTrue();
    }

    @Test
    void shouldReturnFalseWhenAnyRuleFails() {
        ValidationRule trueRule = password -> true;
        ValidationRule falseRule = password -> false;

        PasswordService service = new PasswordService(List.of(trueRule, falseRule));

        boolean result = service.validate("Abc123@");

        assertThat(result).isFalse();
    }

    @Test
    void shouldHandleEmptyPasswordGracefully() {
        ValidationRule notNullRule = password -> password != null;

        PasswordService service = new PasswordService(List.of(notNullRule));

        boolean result = service.validate(null);

        assertThat(result).isFalse();
    }

    @Test
    void shouldReturnTrueWithNoRulesDefined() {
        PasswordService service = new PasswordService(List.of());

        boolean result = service.validate("Abc123@");

        // stream().allMatch em lista vazia retorna true
        assertThat(result).isTrue();
    }
}
