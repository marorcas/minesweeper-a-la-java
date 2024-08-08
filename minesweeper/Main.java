package minesweeper;

public class Main {

    public static void main(String[] args) {
        Grid grid = new Grid(10, 10, 10);

        System.out.println();
        System.out.println("   =============== Play Minesweeper! ===============   ");
        System.out.println();

        System.out.println("   How to play:");
        System.out.println("   1. Enter a column number");
        System.out.println("   2. Enter a row number");
        System.out.println(
                "   3. If a number appears in the box of your chosen coordinates, this indicates how many mines surround that box");
        System.out.println("   4. If you click on a mine, it's game over!");
        System.out.println();
        System.out.println("   Have fun :)");
        System.out.println();

        grid.getGrid();
    }
}