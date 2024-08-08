package minesweeper;

public class Main {

    public static void main(String[] args) {
        Grid grid = new Grid(10, 10, 10);

        System.out.println();
        System.out.println("  =============== Play Minesweeper! ===============  ");

        grid.getGrid();
    }
}