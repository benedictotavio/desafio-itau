package br.com.itau.desafio.ia.ItAu.api.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.itau.desafio.ia.ItAu.api.dto.password.input.PasswordRequestDTO;
import br.com.itau.desafio.ia.ItAu.api.dto.password.output.PasswordResponseDTO;
import br.com.itau.desafio.ia.ItAu.application.service.PasswordService;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@RestController
@RequestMapping("/password")
public class PasswordController {

    private final PasswordService passwordService;

    @PostMapping("/validate")
    public ResponseEntity<PasswordResponseDTO> validate(@RequestBody PasswordRequestDTO request) {
        boolean isValid = passwordService.validate(request.password());
        return ResponseEntity.ok(new PasswordResponseDTO(isValid));
    }
}