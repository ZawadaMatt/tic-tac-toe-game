package ticTacToe;

import java.util.Scanner;

public class Application {
    public static void main(String[] args) {
        TicTacToe ticTacToe = new TicTacToe();
        Scanner scanner = new Scanner(System.in);
        ticTacToe.drawGrid();
        do {
            System.out.println("Now move :" + ticTacToe.nextPlayer());

            ticTacToe.play(scanner.nextInt(), scanner.nextInt());
            ticTacToe.drawGrid();
        } while (!ticTacToe.isWin());
        System.out.println("Win");
    }
}
