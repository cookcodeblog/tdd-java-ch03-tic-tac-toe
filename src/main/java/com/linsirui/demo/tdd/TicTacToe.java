package com.linsirui.demo.tdd;

import java.util.Arrays;

public class TicTacToe {

    private static final int SIZE = 3;

    // '\0' means empty character
    private Character[][] board = {
            {'\0', '\0', '\0'},
            {'\0', '\0', '\0'},
            {'\0', '\0', '\0'}};

    private char lastPlayer = '\0';

    public String play(int x, int y) {
        checkAxis(x, "X");
        checkAxis(y, "Y");
        lastPlayer = nextPlayer();
        setBox(x, y, lastPlayer);
        if (isWin()) {
            return lastPlayer + " is the winner";
        }
        return "No winner";
    }

    private boolean isWin() {
        for (int i = 0 ; i < SIZE; i ++) {
            if (board[0][i] == lastPlayer &&
                    board[1][i] == lastPlayer &&
                    board[2][i] == lastPlayer) {
                return true;
            }
        }
        return false;
    }

    private void setBox(int x, int y, char lastPlayer) {
        if (board[x - 1][y - 1] != '\0') {
            throw new RuntimeException("Box is occupied!");
        } else {
            board[x -1][y - 1] = lastPlayer;
        }
    }

    private void checkAxis(int axis, String name) {
        if (axis < 1 || axis > SIZE) {
            throw new RuntimeException(name + " is outside board");
        }
    }

    public char nextPlayer() {
        return lastPlayer == 'X' ? 'O' : 'X';
    }

    public void snapshot() {
        for (int row = 0; row < SIZE; row ++) {
            System.out.println(Arrays.toString(board[row]));
        }
    }
}
