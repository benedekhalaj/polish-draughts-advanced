package com.codecool.polish_draughts.util;

public class NumberRangePattern {

    private final String pattern;

    public NumberRangePattern(int number) throws IllegalArgumentException {
        if (number >= 100 || number < 1) {
            throw new IllegalArgumentException("Number must be between 1 and 99");
        }
        this.pattern = generateNumberRangePattern(number);
    }

    private String generateNumberRangePattern(int number) {
        StringBuilder pattern = new StringBuilder();
        int firstDigit = number / 10;
        int secondDigit = number % 10;

        if (number >= 10) {
            pattern.append("[1-9]");
            if (firstDigit - 1 > 0) {
                pattern.append("|[1-%d][0-9]".formatted(firstDigit - 1));
            }
            pattern.append("|%d[0-%d]".formatted(firstDigit, secondDigit));
        } else {
            pattern.append("[1-%d]".formatted(number));
        }

        return pattern.toString();
    }

    public String getPattern() {
        return pattern;
    }
}
