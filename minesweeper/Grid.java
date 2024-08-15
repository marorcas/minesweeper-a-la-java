package minesweeper;

public class Grid {
    private Cell[][] gridArray;
    private int rows;
    private int cols;

    // --- constructors ---
    // default grid
    public Grid() {
        this.rows = 10;
        this.cols = 10;
        this.gridArray = new Cell[this.rows][this.cols];
        this.initializeGrid();
    }

    // customised grid
    public Grid(int rows, int cols) {
        this.rows = rows;
        this.cols = cols;
        this.gridArray = new Cell[rows][cols];
        this.initializeGrid();
    }

    private void initializeGrid() {
        for (int i = 0; i < this.rows; i++) {
            for (int j = 0; j < this.cols; j++) {
                this.gridArray[i][j] = new Cell(i, j);
            }
        }
    }

    // --- getter functions ---
    public int getRows() {
        return this.rows;
    }

    public int getCols() {
        return this.cols;
    }

    public Cell[][] getGridArray() {
        return this.gridArray;
    }

    public Cell getCell(int row, int col) {
        return this.gridArray[row][col];
    }

    // --- public functions ---
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

                System.out.print("[ " + this.gridArray[i][j].displayContent() + " ]");
            }
            System.out.println("\n");
        }
    }
}
