package com.sdistribuiti.prezziesconti.gestionesupermercato;

import com.sdistribuiti.prezziesconti.gestionesupermercato.entity.DettListino;
import com.sdistribuiti.prezziesconti.gestionesupermercato.repository.DettListinoRepository;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ContextConfiguration;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest
@ContextConfiguration(classes = GestioneSupermercato.class)
class GestioneSupermercatoTests {

    @Autowired
    private DettListinoRepository dettListRepo;

    @Test
    public void TestFindByCodArt() throws Exception {
        Assertions.assertThat(dettListRepo.findByCodArt("7999182"))
                .extracting(DettListino::getPrezzoFinale)
                .isEqualTo(1.41);
    }

}
