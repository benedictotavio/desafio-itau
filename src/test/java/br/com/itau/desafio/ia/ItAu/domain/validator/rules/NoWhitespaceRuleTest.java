package br.com.itau.desafio.ia.ItAu.domain.validator.rules;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;

class NoWhitespaceRuleTest {

    private final NoWhitespaceRule rule = new NoWhitespaceRule();

    @Test
    void deveRetornarFalseQuandoSenhaForNula() {
        assertFalse(rule.isValid(null));
    }

    @Test
    void deveRetornarFalseQuandoSenhaContemEspacoSimples() {
        assertFalse(rule.isValid("senha comespaco"));
    }

    @Test
    void deveRetornarFalseQuandoSenhaContemTabOuQuebraDeLinha() {
        assertFalse(rule.isValid("senha\tcomtab"));
        assertFalse(rule.isValid("senha\ncomquebra"));
    }

    @Test
    void deveRetornarTrueQuandoSenhaNaoContemEspacos() {
        assertTrue(rule.isValid("SenhaValida123!"));
    }

    @Test
    void deveRetornarTrueQuandoSenhaTemCaracteresEspeciaisMasSemEspacos() {
        assertTrue(rule.isValid("Senha@Valida#2026"));
    }
}