package minesweeper;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        MinesweeperGame game = new MinesweeperGame(10, 10, 10);

        game.getGameInstructions();

        while (game.getGameEndStatus() == false) {
            System.out.println("Enter a row number: ");
            int rowCord = scanner.nextInt();

            System.out.println("Enter a column number: ");
            int colCord = scanner.nextInt();

            game.getCellValue(rowCord, colCord);
        }

        scanner.close();
    }
}