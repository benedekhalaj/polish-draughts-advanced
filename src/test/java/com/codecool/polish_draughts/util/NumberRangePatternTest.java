package com.codecool.polish_draughts.util;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class NumberRangePatternTest {

    @Test
    public void generateNumberRangePattern_HasValidRegex_WhenNumberIs12() {
        String expected = "[1-9]|1[0-2]";
        String actual = new NumberRangePattern(12).getPattern();
        assertEquals(expected, actual);
    }

    @Test
    public void generateNumberRangePattern_HasValidRegex_WhenNumberIs16() {
        String expected = "[1-9]|1[0-6]";
        String actual = new NumberRangePattern(16).getPattern();
        assertEquals(expected, actual);
    }

    @Test
    public void generateNumberRangePattern_HasValidRegex_WhenNumberIs20() {
        String expected = "[1-9]|[1-1][0-9]|2[0-0]";
        String actual = new NumberRangePattern(20).getPattern();
        assertEquals(expected, actual);
    }

    @Test
    public void generateNumberRangePattern_HasValidRegex_WhenNumberIs32() {
        String expected = "[1-9]|[1-2][0-9]|3[0-2]";
        String actual = new NumberRangePattern(32).getPattern();
        assertEquals(expected, actual);
    }

    @Test
    public void generateNumberRangePattern_HasValidRegex_WhenNumberIs65() {
        String expected = "[1-9]|[1-5][0-9]|6[0-5]";
        String actual = new NumberRangePattern(65).getPattern();
        assertEquals(expected, actual);
    }

    @Test
    public void generateNumberRangePattern_HasValidRegex_WhenNumberIs99() {
        String expected = "[1-9]|[1-8][0-9]|9[0-9]";
        String actual = new NumberRangePattern(99).getPattern();
        assertEquals(expected, actual);
    }

}
