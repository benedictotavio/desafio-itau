package br.com.itau.desafio.ia.ItAu.domain.validator.rules;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.springframework.boot.test.context.SpringBootTest;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest
class UppercaseRuleTest {

    private final UppercaseRule rule = new UppercaseRule();

    @ParameterizedTest
    @CsvSource({
        "ABCdef, true",     // contém maiúsculas
        "abcdef, false",    // só minúsculas
        "null, false",      // senha nula
        "123ABC, true",     // dígitos + maiúsculas
        "123456, false",    // apenas dígitos
        "ABCDEF, true"      // apenas maiúsculas
    })
    void shouldValidatePasswordUppercaseRequirement(String password, boolean expected) {
        boolean result = rule.isValid("null".equals(password) ? null : password);
        assertThat(result).isEqualTo(expected);
    }
}


