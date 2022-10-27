package com.codecool.polish_draughts.util;

import io.vavr.control.Either;

public class NumberRangePattern {

    private static final int MINIMUM_NUMBER = 1;
    private static final int MAXIMUM_NUMBER = 99;

    private final Either<String, String> pattern;

    public NumberRangePattern(int number) {
        if (number > MAXIMUM_NUMBER || number < MINIMUM_NUMBER) {
            this.pattern = Either.left("Number must be between 1 and 99");
        } else {
            this.pattern = Either.right(generateNumberRangePattern(number));
        }
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

    public Either<String, String> getPattern() {
        return pattern;
    }
}
