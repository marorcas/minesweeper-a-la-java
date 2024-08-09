package minesweeper;

public class Grid {
    private Cell[][] grid;
    private int cols;
    private int rows;

    public Grid() {
        this.cols = 10;
        this.rows = 10;
        this.grid = new Cell[this.cols][this.rows];
        this.initializeGrid();
    }

    public Grid(int cols, int rows) {
        this.cols = cols;
        this.rows = rows;
        this.grid = new Cell[cols][rows];
        this.initializeGrid();
    }

    public void initializeGrid() {
        for (int i = 0; i < this.cols; i++) {
            for (int j = 0; j < this.rows; j++) {
                this.grid[i][j] = new Cell(i, j);
            }
        }
    }

    // getter functions
    public int getCols() {
        return this.cols;
    }

    public int getRows() {
        return this.rows;
    }

    public Cell[][] getGrid() {
        return this.grid;
    }

    public void displayGrid() {
        System.out.println();

        // to print column coordinates
        for (int i = 0; i < this.cols; i++) {
            if (i == 0) {
                System.out.print("   ");
            }
            System.out.print("  " + i + "  ");
        }

        System.out.println();

        for (int i = 0; i < this.cols; i++) {
            for (int j = 0; j < this.rows; j++) {
                if (j == 0) { // to print row coordinates
                    System.out.print(" " + i + " ");
                }
                System.out.print("[ " + this.grid[i][j].getValueAsChar() + " ]");
            }
            System.out.println("\n");
        }
    }
}
