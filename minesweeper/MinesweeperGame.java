package minesweeper;

import java.util.Arrays;

public class MinesweeperGame {
    private int minecount;
    private Grid gameGrid;
    private boolean gameEndStatus;

    public MinesweeperGame(int rows, int cols, int minecount) {
        this.minecount = minecount;
        this.gameGrid = new Grid(rows, cols);
        this.placeBombs();
        this.gameEndStatus = false;
    }

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

    public void getGameGrid() {
        this.gameGrid.displayGrid();
    }

    public void addBombsToGameGrid() {
        Arrays.stream(this.gameGrid.getGrid())
                .flatMap(Arrays::stream)
                .filter(cell -> cell instanceof BombCell)
                .map(cell -> (BombCell) cell)
                .forEach(bomb -> bomb.detonateBomb());
    }

    public boolean getGameEndStatus() {
        return this.gameEndStatus;
    }

    private void setGameEndStatus() {
        this.addBombsToGameGrid();
        this.gameEndStatus = true;
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
        } else { // if row is the last row in the grid
            rowIdxStart = row - 1;
            rowIdxEnd = row;
        }

        if (col > 0 && col < this.gameGrid.getCols() - 1) {
            colIdxStart = col - 1;
            colIdxEnd = col + 1;
        } else if (col == 0) {
            colIdxStart = col;
            colIdxEnd = col + 1;
        } else { // if col is the last column in the grid
            colIdxStart = col - 1;
            colIdxEnd = col;
        }

        int cellValue = 0;

        if (this.gameGrid.getGrid()[row][col].getValue() == -1) {
            // put all bombs in grid
            System.out.println("BOOM!");
            System.out.println("You lost. Better luck next time :(");
            this.setGameEndStatus();
            return;
        } else {
            for (int i = rowIdxStart; i < rowIdxEnd + 1; i++) {
                for (int j = colIdxStart; j < colIdxEnd + 1; j++) {
                    if (this.gameGrid.getCell(row, col).getXCord() == row
                            && this.gameGrid.getCell(row, col).getYCord() == col) {
                        if (this.gameGrid.getGrid()[i][j].getValue() == -1) {
                            cellValue++;
                            System.out.println(cellValue);
                        }
                    }
                }
            }

            this.gameGrid.getGrid()[row][col].setValue(cellValue);
        }
    }
}
