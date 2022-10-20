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
                            board[i][j] = new Pawn("white");
                        } else {
                            board[i][j] = new Pawn("black");
                        }
                    }
                }
            }
        }
    }

    public void removePawn(Coordinates position) {
        int col = position.getY();
        int row = position.getX();
        board[row][col] = null;
    }

    public void movePawn(Coordinates startingPosition, Coordinates newPosition) {
        int startingCol = startingPosition.getY();
        int startingRow = startingPosition.getX();
        int newCol = newPosition.getY();
        int newRow = newPosition.getX();
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

    public void setBoardLength(int boardLength) {
        this.boardLength = boardLength;
    }



    @Override
    public String toString() {
        // TODO
        return "Board{}";
    }
}
