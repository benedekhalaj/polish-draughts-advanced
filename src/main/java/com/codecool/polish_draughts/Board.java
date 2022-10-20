package com.codecool.polish_draughts;

public class Board {

    private static final int MINIMUM_BOARD_LENGTH = 10;
    private static final int MAXIMUM_BOARD_LENGTH = 20;
    private Pawn[][] board;
    private int boardLength;

    public Board(int boardLength) {
        if (boardLength < MINIMUM_BOARD_LENGTH || boardLength > MAXIMUM_BOARD_LENGTH) {
            throw new IllegalArgumentException("Board length cannot be %d, it must be between %d and %d!"
                    .formatted(boardLength, MINIMUM_BOARD_LENGTH, MAXIMUM_BOARD_LENGTH));
        }
        this.boardLength = boardLength;
    }

    public void removePawn(Coordinates position) {
    }

    public void movePawn(Coordinates initialPosition, Coordinates newPosition) {
        // TODO
    }

    public Pawn[][] getBoard() {
        return board;
    }

    public int getBoardLength() {
        return boardLength;
    }

    public void setBoardLength(int boardLength) {
        this.boardLength = boardLength;
    }



    @Override
    public String toString() {
        // TODO
        return "Board{}";
    }
}
