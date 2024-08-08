package minesweeper;

import java.util.Arrays;

public class Grid {
    private int cols;
    private int rows;
    private int minecount;
    private Character[][] minesArray;
    private Character[][] gameArray;

    public Grid(int cols, int rows, int minecount) {
        this.cols = cols;
        this.rows = rows;
        this.minecount = minecount;
        this.minesArray = new Character[cols][rows];
        this.populateMinesArray();
        this.gameArray = new Character[cols][rows];
        this.populateGameArray();
    }

    public void populateMinesArray() {
        // fill 2-D array with zeros
        for (int i = 0; i < cols; i++) {
            Arrays.fill(this.minesArray[i], '-');
        }

        // generate random indexes for bomb placements
        // have to make sure generated placements are not repeated
        // 'x' represents a bomb
        int count = 0;
        while (count < this.minecount) {
            int randomCol = (int) (Math.random() * (cols));
            int randomRow = (int) (Math.random() * (rows));
            if (this.minesArray[randomCol][randomRow] != 'x') {
                this.minesArray[randomCol][randomRow] = 'x';
                count++;
            }
        }
    }

    public void populateGameArray() {
        for (int i = 0; i < cols; i++) {
            Arrays.fill(this.gameArray[i], ' ');
        }
    }

    public void getGrid() {
        System.out.println();

        for (int i = 0; i < this.cols; i++) {
            if (i == 0) {
                System.out.print("   ");
            }
            System.out.print("  " + i + "  ");
        }

        System.out.println();

        for (int i = 0; i < this.cols; i++) {
            for (int j = 0; j < this.rows; j++) {
                if (j == 0) {
                    System.out.print(" " + i + " ");
                }
                System.out.print("[ " + this.gameArray[i][j] + " ]");
            }
            System.out.println("\n");
        }
    }
}
