package minesweeper;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        MinesweeperGame game = new MinesweeperGame();

        game.getGameInstructions();

        while (game.getGameEndStatus() == false) {
            System.out.println("Enter a row number: ");
            int row = scanner.nextInt();

            System.out.println("Enter a column number: ");
            int col = scanner.nextInt();

            game.getCellValue(row, col);
        }

        scanner.close();
    }
}