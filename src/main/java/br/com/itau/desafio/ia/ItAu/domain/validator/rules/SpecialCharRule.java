package br.com.itau.desafio.ia.ItAu.domain.validator.rules;
import java.util.Set;

import org.springframework.stereotype.Component;

import br.com.itau.desafio.ia.ItAu.domain.validator.ValidationRule;

@Component
public class SpecialCharRule implements ValidationRule {

    private static final Set<Character> SPECIALS = Set.of('!', '@', '#', '$', '%', '^', '&', '*', '(', ')', '-', '+');

    @Override
    public boolean isValid(String password) {
        return password != null && password.chars().anyMatch(ch -> SPECIALS.contains((char) ch));
    }
}

