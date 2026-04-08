package br.com.itau.desafio.ia.ItAu.domain.validator.rules;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.springframework.boot.test.context.SpringBootTest;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest
class SpecialCharRuleTest {

    private final SpecialCharRule rule = new SpecialCharRule();

    @ParameterizedTest
    @CsvSource({
        "abc!def, true",     // contém '!'
        "abcdef, false",     // sem caracteres especiais
        "null, false",       // senha nula
        "123@456, true",     // contém '@'
        "password#, true",   // contém '#'
        "ABCDEF, false",     // só letras maiúsculas
        "Abc123$, true"      // contém '$'
    })
    void shouldValidatePasswordSpecialCharRequirement(String password, boolean expected) {
        boolean result = rule.isValid("null".equals(password) ? null : password);
        assertThat(result).isEqualTo(expected);
    }
}


