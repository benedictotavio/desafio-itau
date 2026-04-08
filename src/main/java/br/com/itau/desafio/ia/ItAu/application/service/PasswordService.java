package br.com.itau.desafio.ia.ItAu.application.service;

import org.springframework.stereotype.Service;

import br.com.itau.desafio.ia.ItAu.domain.validator.ValidationRule;

import java.util.List;

@Service
public class PasswordService {

    private final List<ValidationRule> rules;

    public PasswordService(List<ValidationRule> rules) {
        this.rules = rules;
    }

    /**
     * Valida a senha aplicando todas as regras.
     * @param password senha a ser validada
     * @return true se todas as regras forem satisfeitas
     */
    public boolean validate(String password) {
        return rules.stream().allMatch(rule -> rule.isValid(password));
    }
}
