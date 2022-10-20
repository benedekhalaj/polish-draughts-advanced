package com.codecool.polish_draughts;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class BoardTest {

    @Test
    public void creatingBoard_ThrowsIllegalArgumentException_WhenLengthIsBiggerThan20() {
        assertThrows(IllegalArgumentException.class, () -> {
            new Board(21);
        });
    }

    @Test
    public void creatingBoard_ThrowsIllegalArgumentException_WhenLengthIsSmallerThan10() {
        assertThrows(IllegalArgumentException.class, () -> {
            new Board(9);
        });
    }

    @Test
    public void creatingBoard_HasLength_WhenLengthIs10() {
        int expected = 10;

        Board board = new Board(expected);

        int actual = board.getBoardLength();

        assertEquals(expected, actual);
    }

    @Test
    public void creatingBoard_HasLength_WhenLengthIs20() {
        int expected = 20;

        Board board = new Board(expected);

        int actual = board.getBoardLength();

        assertEquals(expected, actual);
    }

    @Test
    public void creatingBoard_HasLength_WhenLengthIsBetween10And20() {
        int expected = 11;

        Board board = new Board(expected);

        int actual = board.getBoardLength();

        assertEquals(expected, actual);
    }

}
