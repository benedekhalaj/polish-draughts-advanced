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

    @Test
    public void creatingBoard_Has20Pawns_WhenLengthIs10() {
        int expected = 20;

        Pawn[][] board = new Board(10).getBoard();
        int actual = getPawnCount(board);

        assertEquals(expected, actual);
    }

    @Test
    public void creatingBoard_Has30Pawns_WhenLengthIs15() {
        int expected = 30;

        Pawn[][] board = new Board(15).getBoard();
        int actual = getPawnCount(board);

        assertEquals(expected, actual);
    }

    @Test
    public void creatingBoard_Has40Pawns_WhenLengthIs20() {
        int expected = 40;

        Pawn[][] board = new Board(20).getBoard();
        int actual = getPawnCount(board);

        assertEquals(expected, actual);
    }

    @Test
    public void creatingBoard_HasAPawn_AtFirstRowFirstColumn() {
        Board board = new Board(10);
        Pawn[][] pawns = board.getBoard();
        Pawn pawn = pawns[0][0];

        assertNotNull(pawn);
    }

    @Test
    public void creatingBoard_DoesNotHaveAPawn_AtFirstRowSecondColumn() {
        Board board = new Board(10);
        Pawn[][] pawns = board.getBoard();
        Pawn pawn = pawns[0][1];

        assertNull(pawn);
    }

    @Test
    public void creatingBoard_HasTwoEmptyRowsAtTheMiddle_WhenLengthIs10() {
        Board board = new Board(10);
        Pawn[][] pawns = board.getBoard();

        Pawn[][] middleRows = new Pawn[][]{pawns[4], pawns[5]};

        int expected = 0;
        int actual = getPawnCount(middleRows);

        assertEquals(expected, actual);
    }

    private int getPawnCount(Pawn[][] board) {
        int count = 0;
        for (Pawn[] pawns : board) {
            for (Pawn pawn : pawns) {
                if (pawn != null) {
                    count++;
                }
            }
        }
        return count;
    }
}
