package minesweeper;

import java.util.Arrays;

public class MinesweeperGame {
    private int minecount;
    private Grid gameGrid;
    private boolean gameEndStatus;

    // --- constructor ---
    // default
    public MinesweeperGame() {
        this.minecount = 10;
        this.gameGrid = new Grid();
        this.placeBombs();
        this.enterCellsContent();
        this.gameEndStatus = false;
    }

    public MinesweeperGame(int rows, int cols, int minecount) {
        this.minecount = minecount;
        this.gameGrid = new Grid(rows, cols);
        this.placeBombs();
        this.enterCellsContent();
        this.gameEndStatus = false;
    }

    // --- getter functions ---
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
        int count = 0;
        while (count < this.minecount) {
            int randomRow = (int) (Math.random() * (this.gameGrid.getRows()));
            int randomCol = (int) (Math.random() * (this.gameGrid.getCols()));

            if (!this.gameGrid.getCell(randomRow, randomCol).isBomb()) {
                this.gameGrid.getGridArray()[randomRow][randomCol] = new BombCell(randomRow, randomCol);
                count++;
            }
        }
    }

    private int generateCellContent(int row, int col) {
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
        } else {
            rowIdxStart = row - 1;
            rowIdxEnd = row + 1;
        }

        if (col == 0) {
            colIdxStart = col;
            colIdxEnd = col + 1;
        } else if (col == this.gameGrid.getCols() - 1) { // if col is the last column in the grid
            colIdxStart = col - 1;
            colIdxEnd = col;
        } else {
            colIdxStart = col - 1;
            colIdxEnd = col + 1;
        }

        int cellValue = 0;

        for (int i = rowIdxStart; i < rowIdxEnd + 1; i++) {
            for (int j = colIdxStart; j < colIdxEnd + 1; j++) {
                if (this.gameGrid.getCell(i, j).isBomb()) {
                    cellValue++;
                }
            }
        }

        return cellValue;
    }

    private void enterCellsContent() {
        Arrays.stream(this.gameGrid.getGridArray())
                .flatMap(Arrays::stream)
                .filter(cell -> !(cell instanceof BombCell))
                .map(cell -> (Cell) cell)
                .forEach(cell -> {
                    int content = generateCellContent(cell.getXCord(), cell.getYCord());
                    char contentAsChar = (char) (content + '0');
                    cell.setContent(contentAsChar);
                });
        ;
    }

    private void displayBombs() {
        Arrays.stream(this.gameGrid.getGridArray())
                .flatMap(Arrays::stream)
                .filter(cell -> cell instanceof BombCell)
                .map(cell -> (BombCell) cell)
                .forEach(bomb -> bomb.detonateBomb());
    }

    private boolean checkIfWon() {
        return Arrays.stream(this.gameGrid.getGridArray())
                .flatMap(Arrays::stream)
                .filter(cell -> !(cell instanceof BombCell))
                .noneMatch(cell -> !cell.getIsRevealed());
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
        this.gameGrid.displayGrid();
    }

    public boolean checkCoordinateValidity(int number) {
        if (number < 0 || number >= this.gameGrid.getGridArray().length) {
            System.out.println(" !!! Invalid coordinate. Please enter a valid number !!! ");
            return false;
        }

        return true;
    }

    public void revealCellContent(int row, int col) {
        if (this.gameGrid.getCell(row, col).isBomb()) {
            // put all bombs in grid
            System.out.println("   ===============       BOOM!       ===============   ");
            System.out.println("Game over :(");
            this.setGameEndStatus();
            this.displayBombs();
            this.gameGrid.displayGrid();
            return;
        } else if (this.gameGrid.getCell(row, col).getIsRevealed()) {
            System.out.println(
                    " !!! You already selected this cell. Please enter different coordinates. !!! ");
            return;
        } else {
            this.gameGrid.getCell(row, col).setIsRevealedToTrue();

            if (checkIfWon()) {
                this.setGameEndStatus();
                System.out.println("   ===============      YOU WON!       ===============   ");
            }

            this.gameGrid.displayGrid();
        }
    }
}
