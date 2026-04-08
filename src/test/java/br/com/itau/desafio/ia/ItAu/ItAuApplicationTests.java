package br.com.itau.desafio.ia.ItAu;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import static org.assertj.core.api.Assertions.assertThatCode;

@SpringBootTest
class ItAuApplicationTests {

    @Test
    void contextLoads() {
        // Verifica se o contexto do Spring sobe sem problemas
    }

    @Test
    void mainMethodRunsWithoutExceptions() {
        assertThatCode(() -> ItAuApplication.main(new String[]{}))
                .doesNotThrowAnyException();
    }
}
