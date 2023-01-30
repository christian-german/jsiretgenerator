package com.christiangerman.jsiretgenerator;

import org.apache.commons.validator.routines.checkdigit.LuhnCheckDigit;
import org.junit.jupiter.api.Test;

import java.util.Random;

import static com.christiangerman.jsiretgenerator.LuhnGenerator.generateLuhnNumber;
import static com.christiangerman.jsiretgenerator.LuhnGenerator.pad;
import static org.assertj.core.api.Assertions.assertThat;

public class LuhnGeneratorTest {

    @Test
    public void generated_luhn_number_should_be_valid() {
        for (int i = 0; i < 10000; i++) {
            assertThat(new LuhnCheckDigit().isValid(generateLuhnNumber(14))).isTrue();
        }
    }

    @Test
    public void padding_a_random_number_should_generate_a_valid_luhn_number() {
        for (int i = 0; i < 10000; i++) {
            int randomNumber = new Random().nextInt(999999999);
            assertThat(new LuhnCheckDigit().isValid(pad(String.valueOf(randomNumber), 14))).isTrue();
        }
    }

    @Test
    public void padding_a_luhn_number_should_generate_a_valid_luhn_number() {
        for (int i = 0; i < 10000; i++) {
            String luhnNumber = generateLuhnNumber(9);
            assertThat(new LuhnCheckDigit().isValid(pad(luhnNumber, 14))).isTrue();
        }
    }
}
