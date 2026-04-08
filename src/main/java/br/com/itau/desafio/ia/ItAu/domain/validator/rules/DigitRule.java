package br.com.itau.desafio.ia.ItAu.domain.validator.rules;

import br.com.itau.desafio.ia.ItAu.domain.validator.ValidationRule;

public class DigitRule implements ValidationRule {
    @Override
    public boolean isValid(String password) {
        return password != null && password.chars().anyMatch(Character::isDigit);
    }
}