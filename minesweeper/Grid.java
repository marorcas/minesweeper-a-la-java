package minesweeper;

public class Grid {
    private Cell[][] grid;
    private int rows;
    private int cols;

    // === constructors ===
    // default values if none entered
    public Grid() {
        this.rows = 10;
        this.cols = 10;
        this.grid = new Cell[this.rows][this.cols];
        this.initializeGrid();
    }

    public Grid(int rows, int cols) {
        this.rows = rows;
        this.cols = cols;
        this.grid = new Cell[rows][cols];
        this.initializeGrid();
    }

    // === getter functions ===
    public int getRows() {
        return this.rows;
    }

    public int getCols() {
        return this.cols;
    }

    public Cell[][] getGrid() {
        return this.grid;
    }

    public Cell getCell(int row, int col) {
        return this.grid[row][col];
    }

    // === private functions ===
    private void initializeGrid() {
        for (int i = 0; i < this.rows; i++) {
            for (int j = 0; j < this.cols; j++) {
                this.grid[i][j] = new Cell(i, j);
            }
        }
    }

    // === public functions ===
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

        for (int i = 0; i < this.rows; i++) {
            for (int j = 0; j < this.cols; j++) {
                if (j == 0) { // to print row coordinates
                    System.out.print(" " + i + " ");
                }

                System.out.print("[ " + this.grid[i][j].getValueAsChar() + " ]");
            }
            System.out.println("\n");
        }
    }
}
