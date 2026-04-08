package br.com.itau.desafio.ia.ItAu.domain.validator.rules;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.springframework.boot.test.context.SpringBootTest;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest
class DigitRuleTest {

    private final DigitRule rule = new DigitRule();

    @ParameterizedTest
    @CsvSource({
            "abc123, true",
            "abcdef, false",
            "null, false",
            "1abcdef, true",
            "abcdef9, true",
            "123456, true"
    })
    void shouldValidatePasswordDigitRequirement(String password, boolean expected) {
        boolean result = rule.isValid(password);
        assertThat(result).isEqualTo(expected);
    }
}
