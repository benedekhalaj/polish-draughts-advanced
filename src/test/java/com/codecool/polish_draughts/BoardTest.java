package com.codecool.polish_draughts;

import com.codecool.polish_draughts.model.Board;
import com.codecool.polish_draughts.model.Cell;
import com.codecool.polish_draughts.model.Pawn;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

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
    public void creatingBoard_Has40Pawns_WhenLengthIs10() {
        int expected = 40;

        Pawn[][] board = new Board(10).getBoard();
        int actual = getPawnCount(board);

        assertEquals(expected, actual);
    }

    @Test
    public void creatingBoard_Has60Pawns_WhenLengthIs15() {
        int expected = 60;

        Pawn[][] board = new Board(15).getBoard();
        int actual = getPawnCount(board);

        assertEquals(expected, actual);
    }

    @Test
    public void creatingBoard_Has80Pawns_WhenLengthIs20() {
        int expected = 80;

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

    @Test
    public void removePawn_RemovesPawn_WhenCalledWithPawnCoordinates() {
        Board board = getEmptyBoard();
        Pawn[][] pawns = board.getBoard();
        pawns[0][0] = new Pawn("white");

        board.removePawn(new Cell(0, 0));

        assertNull(pawns[0][0]);
    }

    @Test
    public void movePawn_RemovesPawnFromOldPosition_WhenCalledWithPawnCoordinates() {
        Board board = getEmptyBoard();
        Pawn[][] pawns = board.getBoard();
        pawns[0][0] = new Pawn("white");
        Cell startingPosition = new Cell(0, 0);
        Cell newPosition = new Cell(1, 0);

        board.movePawn(startingPosition, newPosition);

        assertNull(pawns[0][0]);

    }

    @Test
    public void movePawn_MovesPawnToNewPosition_WhenCalledWithPawnCoordinates() {
        Board board = getEmptyBoard();
        Pawn[][] pawns = board.getBoard();
        pawns[0][0] = new Pawn("white");
        Cell startingPosition = new Cell(0, 0);
        Cell newPosition = new Cell(1, 0);

        board.movePawn(startingPosition, newPosition);

        assertNotNull(pawns[1][0]);
    }

    private Board getEmptyBoard() {
        Board board = new Board(10);
        Pawn[][] pawns = board.getBoard();
        for (Pawn[] pawn : pawns) {
            Arrays.fill(pawn, null);
        }
        return board;
    }

}
