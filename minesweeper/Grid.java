package minesweeper;

public class Grid {
    private int cols;
    private int rows;

    public Grid(int cols, int rows) {
        this.cols = cols;
        this.rows = rows;
    }

    public void getGrid() {
        for (int i = 0; i < this.rows; i++) {
            for (int j = 0; j < this.cols; j++) {
                System.out.print("[ ]");
            }
            System.out.println("\n");
        }
    }
}
