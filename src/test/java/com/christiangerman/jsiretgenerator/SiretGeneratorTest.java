package com.christiangerman.jsiretgenerator;

import org.apache.commons.validator.routines.checkdigit.LuhnCheckDigit;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class SiretGeneratorTest {

    private final SiretGenerator siretGenerator = SiretGeneratorFactory.createSiretGenerator();

    @Test
    public void generated_siret_should_be_valid() {
        for (int i = 0; i < 10000; i++) {
            assertThat(new LuhnCheckDigit().isValid(siretGenerator.generateSiret().getSiren())).isTrue();
        }
    }
}
