package minesweeper;

public class MinesweeperGame {
    private int cols;
    private int rows;
    private int minecount;
    private Grid minesTracker;
    private Grid gameGrid;

    public MinesweeperGame(int cols, int rows, int minecount) {
        this.cols = cols;
        this.rows = rows;
        this.minecount = minecount;
        this.minesTracker = new Grid(cols, rows);
        this.placeBombs();
        this.gameGrid = new Grid(cols, rows);
    }

    private void placeBombs() {
        // generate random indexes for bomb placements
        // have to make sure generated placements are not repeated
        // -1 represents a bomb
        int count = 0;
        while (count < this.minecount) {
            int randomCol = (int) (Math.random() * (cols));
            int randomRow = (int) (Math.random() * (rows));
            if (this.minesTracker.getGrid()[randomCol][randomRow].getValue() != -1) {
                this.minesTracker.getGrid()[randomCol][randomRow] = new BombCell(randomCol, randomRow);
                count++;
            }
        }
    }

    public void getGameGrid() {
        this.gameGrid.displayGrid();
    }

    public void getBombGrid() {
        this.minesTracker.displayGrid();
    }

    // public void getCellValue(int col, int row) {
    // int colIdxStart;
    // int colIdxEnd;
    // int rowIdxStart;
    // int rowIdxEnd;

    // if (col > 0 && col < this.cols - 1) {
    // colIdxStart = col - 1;
    // colIdxEnd = col + 1;
    // } else if (col == 0) {
    // colIdxStart = col;
    // colIdxEnd = col + 1;
    // } else { // if col is the last column in the grid
    // colIdxStart = col - 1;
    // colIdxEnd = col;
    // }

    // if (row > 0 && row < this.rows - 1) {
    // rowIdxStart = row - 1;
    // rowIdxEnd = row + 1;
    // } else if (row == 0) {
    // rowIdxStart = row;
    // rowIdxEnd = row + 1;
    // } else { // if row is the last row in the grid
    // rowIdxStart = row - 1;
    // rowIdxEnd = row;
    // }

    // int cellValue;

    // if (minesArray[col][row] == -1) {
    // gameArray[col][row] = 'x';
    // System.out.println("BOOM");
    // return;
    // } else {

    // }

    // for (int i = colIdxStart; i < colIdxEnd + 1; i++) {
    // for (int j = rowIdxStart; j < rowIdxEnd + 1; j++) {

    // }
    // }
    // }
}
