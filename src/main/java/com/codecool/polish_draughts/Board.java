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
        initBoard(boardLength);
    }

    private void initBoard(int boardLength) {
        this.board = new Pawn[boardLength][boardLength];
        int whitePawnThresholdIndex = 4;
        int blackPawnThresholdIndex = boardLength - 5;
        for (int i = 0; i < boardLength; i++) {
            boolean inThreshold = (i < whitePawnThresholdIndex || i > blackPawnThresholdIndex);
            int rowParity = i % 2;
            if (inThreshold) {
                for (int j = 0; j < boardLength; j++) {
                    int colParity = j % 2;
                    if (rowParity == colParity) {
                        boolean createWhitePawn = (i < whitePawnThresholdIndex);
                        if (createWhitePawn) {
                            board[i][j] = new Pawn("white", new Coordinates(j, i));
                        } else {
                            board[i][j] = new Pawn("black", new Coordinates(j, i));
                        }
                    }
                }
            }
        }
    }

    public void removePawn(Coordinates position) {
        int col = position.getX();
        int row = position.getY();
        board[row][col] = null;
    }

    public void movePawn(Coordinates initialPosition, Coordinates newPosition) {
        int col = initialPosition.getX();
        int row = initialPosition.getY();
        board[row][col].setPosition(newPosition);
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
