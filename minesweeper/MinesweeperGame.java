package minesweeper;

import java.util.Arrays;

public class MinesweeperGame {
    private int minecount;
    private Grid gameGrid;
    private boolean gameEndStatus;

    // === constructors ===
    // default values if none are entered
    public MinesweeperGame() {
        this.minecount = 10;
        this.gameGrid = new Grid(); // 10x10
        this.placeBombs();
        this.gameEndStatus = false;
    }

    public MinesweeperGame(Grid grid, int minecount) {
        this.minecount = minecount;
        this.gameGrid = grid;
        this.placeBombs();
        this.gameEndStatus = false;
    }

    // === getter functions ===
    private void getGameGrid() {
        this.gameGrid.displayGrid();
    }

    public boolean getGameEndStatus() {
        return this.gameEndStatus;
    }

    // === setter functions ===
    private void setGameEndStatus() {
        this.gameEndStatus = true;
    }

    // === private functions ===
    private void placeBombs() {
        // generate random indexes for bomb placements
        // have to make sure generated placements are not repeated
        // -1 represents a bomb
        int count = 0;
        while (count < this.minecount) {
            int randomRow = (int) (Math.random() * (this.gameGrid.getRows()));
            int randomCol = (int) (Math.random() * (this.gameGrid.getCols()));
            if (this.gameGrid.getCell(randomRow, randomCol).getValue() != -1) {
                this.gameGrid.getGrid()[randomRow][randomCol] = new BombCell(randomRow, randomCol);
                count++;
            }
        }
    }

    private void displayBombs() {
        Arrays.stream(this.gameGrid.getGrid())
                .flatMap(Arrays::stream)
                .filter(cell -> cell instanceof BombCell)
                .map(cell -> (BombCell) cell)
                .forEach(bomb -> bomb.detonateBomb());
    }

    private boolean checkIfWon() {
        // returns true if no elements match -2
        return Arrays.stream(this.gameGrid.getGrid())
                .flatMap(Arrays::stream)
                .noneMatch(cell -> cell.getValue() == -2);
    }

    // === public functions ===
    public void getGameInstructions() {
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
        System.out.println("Start playing!");
        this.getGameGrid();
    }

    public void getCellValue(int row, int col) {
        int rowIdxStart;
        int rowIdxEnd;
        int colIdxStart;
        int colIdxEnd;

        if (row > 0 && row < this.gameGrid.getRows() - 1) {
            rowIdxStart = row - 1;
            rowIdxEnd = row + 1;
        } else if (row == 0) {
            rowIdxStart = row;
            rowIdxEnd = row + 1;
        } else if (row == this.gameGrid.getRows() - 1) { // if row is the last row in the grid
            rowIdxStart = row - 1;
            rowIdxEnd = row;
        } else { // Out of bounds coordinate
            System.out.println(" !!! Invalid coordinate. Please enter a valid number !!! ");
            return;
        }

        if (col > 0 && col < this.gameGrid.getCols() - 1) {
            colIdxStart = col - 1;
            colIdxEnd = col + 1;
        } else if (col == 0) {
            colIdxStart = col;
            colIdxEnd = col + 1;
        } else if (col == this.gameGrid.getCols() - 1) { // if col is the last column in the grid
            colIdxStart = col - 1;
            colIdxEnd = col;
        } else { // Out of bounds coordinate
            System.out.println(" !!! Invalid coordinate. Please enter a valid number !!! ");
            return;
        }

        int cellValue = 0;

        if (this.gameGrid.getCell(row, col).getValue() == -1) {
            // put all bombs in grid
            System.out.println("   ===============       BOOM!       ===============   ");
            System.out.println("Game over :(");
            this.setGameEndStatus();
            this.displayBombs();
            this.getGameGrid();
            return;
        } else if (this.gameGrid.getCell(row, col).getValue() != -2) {
            System.out.println(
                    " !!! You already selected this cell. Please enter different coordinates. !!! ");
            return;
        } else {
            for (int i = rowIdxStart; i < rowIdxEnd + 1; i++) {
                for (int j = colIdxStart; j < colIdxEnd + 1; j++) {
                    if (this.gameGrid.getCell(row, col).getXCord() == row
                            && this.gameGrid.getCell(row, col).getYCord() == col) {
                        if (this.gameGrid.getGrid()[i][j].getValue() == -1) {
                            cellValue++;
                        }
                    }
                }
            }

            this.gameGrid.getGrid()[row][col].setValue(cellValue);

            if (checkIfWon() == true) {
                this.setGameEndStatus();
                System.out.println("   ===============      YOU WON!       ===============   ");
            }

            this.getGameGrid();
        }
    }
}
