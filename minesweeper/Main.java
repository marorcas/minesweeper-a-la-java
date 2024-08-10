package minesweeper;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        MinesweeperGame game = new MinesweeperGame(10, 10, 10);

        game.getGameInstructions();

        Scanner scanner = new Scanner(System.in);

        System.out.println("Start playing!");
        game.getGameGrid();

        while (game.getGameEndStatus() == false) {
            System.out.println("Enter a row number: ");
            int rowCord = scanner.nextInt();

            System.out.println("Enter a column number: ");
            int colCord = scanner.nextInt();

            game.getCellValue(rowCord, colCord);

            // game.getGameGrid();
        }

        game.getGameGrid();

        scanner.close();
    }
}