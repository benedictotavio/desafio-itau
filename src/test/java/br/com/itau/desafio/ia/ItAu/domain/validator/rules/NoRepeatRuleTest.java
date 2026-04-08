package br.com.itau.desafio.ia.ItAu.domain.validator.rules;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.springframework.boot.test.context.SpringBootTest;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest
class NoRepeatRuleTest {

    private final NoRepeatRule rule = new NoRepeatRule();

    @ParameterizedTest
    @CsvSource({
        "abcdef, true",       // todos diferentes
        "abcdea, false",      // 'a' repetido
        "null, false",        // senha nula
        "123456, true",       // dígitos sem repetição
        "1123456, false",     // dígito repetido
        "AbcDefG, true",      // mistura sem repetição
        "AaBbCc, true"       // letras repetidas
    })
    void shouldValidateNoRepeatRequirement(String password, boolean expected) {
        boolean result = rule.isValid("null".equals(password) ? null : password);
        assertThat(result).isEqualTo(expected);
    }
}