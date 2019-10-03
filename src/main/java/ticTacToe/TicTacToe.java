package ticTacToe;

public class TicTacToe {
    private Character[][] board = {
            {'\0', '\0', '\0'},
            {'\0', '\0', '\0'},
            {'\0', '\0', '\0'}
    };
    private char lastPlayer = '\0';

    public String play(int x, int y) {
        checkAxis(x);
        checkAxis(y);
        lastPlayer = nextPlayer();
        setBox(x, y);
        if (isWin()) {
            return lastPlayer + " is the winner";
        }
        return "No winner";
    }

    public boolean isWin() {
        int playerTotal = lastPlayer * 3;
        for (int index = 0; index < 3; index++) {
            if (board[0][index] + board[1][index] + board[2][index] == playerTotal) {
                return true;
            } else if (board[index][0] + board[index][1] + board[index][2] == playerTotal) {
                return true;
            }
        }
        if (board[0][0] + board[1][1] + board[2][2] == playerTotal) {
            return true;
        } else if (board[2][0] + board[1][1] + board[0][2] == playerTotal) {
            return true;
        }
        return false;
    }

    private void checkAxis(int axis) {
        if (axis < 1 || axis > 3) {
            throw new RuntimeException("Outside the board");
        }
    }

    public void setBox(int x, int y) {
        if (board[x - 1][y - 1] != '\0') {
            throw new RuntimeException("This position is occupied");
        } else {
            board[x - 1][y - 1] = lastPlayer;
        }
    }

    public char nextPlayer() {
        return (lastPlayer == 'X') ? 'O' : 'X';
    }

    public void drawGrid() {
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                System.out.print("|" + board[i][j]);
            }
            System.out.print("|" + "\n");
        }
    }
}
