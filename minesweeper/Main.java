package minesweeper;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        MinesweeperGame game = new MinesweeperGame(10, 10, 10);

        game.getGameInstructions();

        Scanner scanner = new Scanner(System.in);

        while (game.getGameEndStatus() == false) {
            System.out.println("Enter a row number: ");
            int row = scanner.nextInt();

            if (!game.checkCoordinateValidity(row)) {
                continue;
            }

            System.out.println("Enter a column number: ");
            int col = scanner.nextInt();

            if (!game.checkCoordinateValidity(col)) {
                continue;
            }

            game.getCellValue(row, col);
        }

        scanner.close();
    }
}