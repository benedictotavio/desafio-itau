package br.com.itau.desafio.ia.ItAu.domain.validator.rules;

import org.springframework.stereotype.Component;

import br.com.itau.desafio.ia.ItAu.domain.validator.ValidationRule;

@Component
public class NoWhitespaceRule implements ValidationRule {
    @Override
    public boolean isValid(String password) {
        return password != null && !password.matches(".*\\s+.*");
    }
}