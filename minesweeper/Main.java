package minesweeper;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        MinesweeperGame game = new MinesweeperGame();

        game.getGameInstructions();

        Scanner scanner = new Scanner(System.in);

        while (game.getGameEndStatus() == false) {
            int row;
            int col;

            try {
                System.out.println("Enter a row number: ");
                row = scanner.nextInt();

                if (!game.checkCoordinateValidity(row)) {
                    continue;
                }
            } catch (InputMismatchException e) {
                System.out.println("Please enter a numerical value.");
                scanner.next();
                continue;
            }

            try {
                System.out.println("Enter a column number: ");
                col = scanner.nextInt();

                if (!game.checkCoordinateValidity(col)) {
                    continue;
                }
            } catch (InputMismatchException e) {
                System.out.println("Please enter a numerical value.");
                scanner.next();
                continue;
            }

            game.revealCellContent(row, col);
        }

        scanner.close();
    }
}