package com.christiangerman.jsiretgenerator;

import java.util.Random;

public class LuhnGenerator {

    private static final Random random = new Random();

    /**
     * Generates a random Luhn number with the specified number of digits.
     *
     * @param numberOfDigits The size of the number.
     * @return A random number validated by Luhn's algorithm.
     */
    public static String generateLuhnNumber(int numberOfDigits) {

        StringBuilder builder = new StringBuilder();

        for (int i = 0; i < numberOfDigits - 1; i++) {
            int digit = random.nextInt(10);
            builder.append(digit);
        }

        int sum = calculateSum(builder.toString());
        int checksum = (10 - (sum % 10)) % 10;
        builder.append(checksum);

        return builder.toString();
    }

    public static String pad(String number, int numberOfDigits) {
        int numberOfDigitsToAdd = numberOfDigits - number.length();
        StringBuilder builder = new StringBuilder();
        builder.append(number);

        for (int i = 0; i < numberOfDigitsToAdd - 1; i++) {
            int digit = random.nextInt(10);
            builder.append(digit);
        }

        int sum = calculateSum(builder.toString());
        int checksum = (10 - (sum % 10)) % 10;
        builder.append(checksum);

        return builder.toString();
    }

    private static int calculateSum(String number) {
        int numberOfDigits = number.length();
        int sum = 0;

        for (int i = 0; i < numberOfDigits; i++) {
            int digit = Character.getNumericValue(number.charAt(i));
            if (i % 2 == (numberOfDigits - 1) % 2) {
                digit *= 2;
                if (digit > 9) {
                    digit = digit / 10 + digit % 10;
                }
            }
            sum += digit;
        }
        return sum;
    }
}
