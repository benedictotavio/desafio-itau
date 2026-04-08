package br.com.itau.desafio.ia.ItAu.domain.validator.rules;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.springframework.boot.test.context.SpringBootTest;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest
class LowercaseRuleTest {

    private final LowercaseRule rule = new LowercaseRule();

    @ParameterizedTest
    @CsvSource({
        "abcDEF, true",      // contém minúsculas
        "ABCDEF, false",     // só maiúsculas
        "null, false",       // senha nula
        "123abc, true",      // dígitos + minúsculas
        "123456, false",     // apenas dígitos
        "abcdef, true"       // apenas minúsculas
    })
    void shouldValidatePasswordLowercaseRequirement(String password, boolean expected) {
        boolean result = rule.isValid("null".equals(password) ? null : password);
        assertThat(result).isEqualTo(expected);
    }
}


