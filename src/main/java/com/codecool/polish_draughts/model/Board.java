package com.codecool.polish_draughts.model;

public class Board {

    private static final int MINIMUM_BOARD_LENGTH = 10;
    private static final int MAXIMUM_BOARD_LENGTH = 20;
    private Pawn[][] board;
    private final int boardLength;

    public Board(int boardLength) {
        if (boardLength < MINIMUM_BOARD_LENGTH || boardLength > MAXIMUM_BOARD_LENGTH) {
            throw new IllegalArgumentException("Board length cannot be %d, it must be between %d and %d!"
                    .formatted(boardLength, MINIMUM_BOARD_LENGTH, MAXIMUM_BOARD_LENGTH));
        }
        this.boardLength = boardLength;
        initBoard();
    }

    private void initBoard() {
        board = new Pawn[boardLength][boardLength];
        int whitePawnThresholdIndex = 4;
        int blackPawnThresholdIndex = boardLength - 5;
        for (int row = 0; row < boardLength; row++) {
            boolean inThreshold = (row < whitePawnThresholdIndex || row > blackPawnThresholdIndex);
            if (!inThreshold) {
                continue;
            }
            int rowParity = row % 2;
            for (int col = 0; col < boardLength; col++) {
                int colParity = col % 2;
                if (rowParity != colParity) {
                    continue;
                }
                boolean isWhitePawn = row < whitePawnThresholdIndex;
                String color = (isWhitePawn) ? "white" : "black";
                board[row][col] = new Pawn(color);
            }
        }
    }

    public void removePawn(Cell position) {
        int row = position.getRow();
        int col = position.getColumn();
        board[row][col] = null;
    }

    public void movePawn(Cell startingPosition, Cell newPosition) {
        int startingRow = startingPosition.getRow();
        int startingCol = startingPosition.getColumn();
        int newRow = newPosition.getRow();
        int newCol = newPosition.getColumn();
        Pawn pawn = board[startingRow][startingCol];
        board[newRow][newCol] = pawn;
        removePawn(startingPosition);
    }

    public Pawn[][] getBoard() {
        return board;
    }

    public int getBoardLength() {
        return boardLength;
    }

    @Override
    public String toString() {
        // TODO
        return "Board{}";
    }
}
