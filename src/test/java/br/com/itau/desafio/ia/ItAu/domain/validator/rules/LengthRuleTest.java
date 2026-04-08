package br.com.itau.desafio.ia.ItAu.domain.validator.rules;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.springframework.boot.test.context.SpringBootTest;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest
class LengthRuleTest {

    private final LengthRule rule = new LengthRule();

    @ParameterizedTest
    @CsvSource({
        "Abcdef123, true",     // exatamente 9 caracteres
        "Abc123, false",       // menos de 9 caracteres
        "null, false",         // senha nula
        "123456789, true",     // exatamente 9 dígitos
        "Abcdefghij123, true"  // mais de 9 caracteres
    })
    void shouldValidatePasswordLengthRequirement(String password, boolean expected) {
        boolean result = rule.isValid("null".equals(password) ? null : password);
        assertThat(result).isEqualTo(expected);
    }
}
