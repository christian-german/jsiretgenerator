package com.christiangerman.jsiretgenerator;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class SiretGeneratorImplTest {

    private final SiretGeneratorImpl siretGenerator = new SiretGeneratorImpl();

    @Test
    public void shouldAnswerWithTrue() {
        assertThat(siretGenerator.siret()).isNotNull();
    }
}
