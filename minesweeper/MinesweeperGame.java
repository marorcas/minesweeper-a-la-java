package minesweeper;

import java.util.Arrays;

public class MinesweeperGame {
    private int minecount;
    private Grid gameGrid;
    private boolean gameEndStatus;

    // --- constructor ---
    public MinesweeperGame(int rows, int cols, int minecount) {
        this.minecount = minecount;
        this.gameGrid = grid;
        this.placeBombs();
        this.gameEndStatus = false;
    }

    // --- getter functions ---
    private void getGameGrid() {
        this.gameGrid.displayGrid();
    }

    public boolean getGameEndStatus() {
        return this.gameEndStatus;
    }

    // --- setter functions ---
    private void setGameEndStatus() {
        this.gameEndStatus = true;
    }

    // --- private functions ---
    private void placeBombs() {
        // generate random indexes for bomb placements
        // have to make sure generated placements are not repeated
        // -1 represents a bomb
        int count = 0;
        while (count < this.minecount) {
            int randomRow = (int) (Math.random() * (this.gameGrid.getRows()));
            int randomCol = (int) (Math.random() * (this.gameGrid.getCols()));

            if (this.gameGrid.getGrid()[randomRow][randomCol].getValue() != -1) {
                this.gameGrid.getGrid()[randomRow][randomCol] = new BombCell(randomRow, randomCol);
                count++;
            }
        }
    }

    private void addBombsToGameGrid() {
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

    // --- public functions ---
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

    public boolean checkCoordinateValidity(int number) {
        if (number < 0 || number >= this.gameGrid.getGrid().length) {
            System.out.println(" !!! Invalid coordinate. Please enter a valid number !!! ");
            return false;
        }

        return true;
    }

    public void getCellValue(int row, int col) {
        int rowIdxStart;
        int rowIdxEnd;
        int colIdxStart;
        int colIdxEnd;

        if (row == 0) {
            rowIdxStart = row;
            rowIdxEnd = row + 1;
        } else if (row == this.gameGrid.getRows() - 1) { // if row is the last row in the grid
            rowIdxStart = row - 1;
            rowIdxEnd = row;
        } else { // row is within range
            rowIdxStart = row - 1;
            rowIdxEnd = row + 1;
        }

        if (col == 0) {
            colIdxStart = col;
            colIdxEnd = col + 1;
        } else if (col == this.gameGrid.getCols() - 1) { // if col is the last column in the grid
            colIdxStart = col - 1;
            colIdxEnd = col;
        } else { // col is within range
            colIdxStart = col - 1;
            colIdxEnd = col + 1;
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
        } else if (this.gameGrid.getCell(row, col).getIsRevealed() == true) {
            System.out.println(
                    " !!! You already selected this cell. Please enter different coordinates. !!! ");
            return;
        } else {
            this.gameGrid.getCell(row, col).setIsRevealedToTrue();
            if (this.gameGrid.getCell(row, col).getValue() == 0) {
                this.revealAdjacentCells(row, col);
            }

            if (checkIfWon() == true) {
                this.setGameEndStatus();
                System.out.println("   ===============      YOU WON!       ===============   ");
            }
        }

        this.getGameGrid();
    }
}
