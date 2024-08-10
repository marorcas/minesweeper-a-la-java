package minesweeper;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        MinesweeperGame game = new MinesweeperGame(10, 10, 10);

        System.out.println();
        System.out.println("   =============== Play Minesweeper! ===============   ");
        System.out.println();

        System.out.println("   How to play:");
        System.out.println("   1. Enter a row number");
        System.out.println("   2. Enter a column number");
        System.out.println(
                "   3. If a number appears in the box of your chosen coordinates, this indicates how many mines surround that box");
        System.out.println("   4. If you click on a mine, it's game over!");
        System.out.println();
        System.out.println("   Have fun :)");
        System.out.println();

        Scanner scanner = new Scanner(System.in);

        game.getGameGrid();

        while (game.getGameEndStatus() == false) {
            System.out.println("Enter a row number: ");
            int rowCord = scanner.nextInt();

            System.out.println("Enter a column number: ");
            int colCord = scanner.nextInt();

            game.getCellValue(rowCord, colCord);

            game.getGameGrid();
        }

        scanner.close();
    }
}