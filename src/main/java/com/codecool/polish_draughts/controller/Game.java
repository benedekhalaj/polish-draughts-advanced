package com.codecool.polish_draughts.controller;

import com.codecool.polish_draughts.model.Board;
import com.codecool.polish_draughts.model.Cell;
import com.codecool.polish_draughts.view.Display;
import io.vavr.control.Either;

public class Game {

    private static final char PLAYER_1 = '0';
    private static final char PLAYER_2 = 'X';

    private final Board board;

    private final Display display;

    public Game(Board board, Display display) {
        this.board = board;
        this.display = display;
    }

    private char currentPlayer = PLAYER_1;
    private boolean isRunning = false;

    public void start() {
        display.printGameStartText();
        isRunning = true;
        while (isRunning) {
            playRound();
            switchPlayer();
        }
    }

    private void switchPlayer() {
        if (currentPlayer == PLAYER_1) {
            currentPlayer = PLAYER_2;
        } else {
            currentPlayer = PLAYER_1;
        }
    }

    private void playRound() {
        // TODO
    }

    private void tryToMakeMove() {
        // TODO
    }

    private void checkForWinner() {
        // TODO
    }

}
