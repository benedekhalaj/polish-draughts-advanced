package com.codecool.polish_draughts;

public class Game {

    private static final char PLAYER_1 = '0';
    private static final char PLAYER_2 = 'X';
    private char currentPlayer = PLAYER_1;
    private boolean isRunning = false;

    public void start() {
        printGameStartText();
        isRunning = true;
        while (isRunning) {
            playRound();
            switchPlayer();
        }
    }

    private static void printGameStartText() {
        System.out.println("Hello Dear Players! Let's start our Polish Draughts Adventure!");
        System.out.println("---------------------- POLISH DRAUGHTS -----------------------");
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
