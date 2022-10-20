package com.codecool.polish_draughts;

public class Board {

    private Pawn[][] board;
    private int boardLength;

    public Board(int boardLength) {
        this.boardLength = boardLength;
    }

    public void removePawn(Coordinates position) {
        // TODO
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
