package br.com.itau.desafio.ia.ItAu.domain.validator.rules;

import org.springframework.stereotype.Component;

import br.com.itau.desafio.ia.ItAu.domain.validator.ValidationRule;

import java.util.HashSet;
import java.util.Set;

@Component
public class NoRepeatRule implements ValidationRule {
    @Override
    public boolean isValid(String password) {
        if (password == null)
            return false;
        Set<Character> seen = new HashSet<>();
        for (char c : password.toCharArray()) {
            if (!seen.add(c)) {
                return false;
            }
        }
        return true;
    }
}
