package minesweeper;

import java.util.Arrays;

public class Grid {
    private int cols;
    private int rows;
    private int minecount;
    private int[][] minesArray;

    public Grid(int cols, int rows, int minecount) {
        this.cols = cols;
        this.rows = rows;
        this.minecount = minecount;
        this.minesArray = new int[cols][rows];
        this.getBombs();
    }

    public void getBombs() {
        // fill 2-D array with zeros
        for (int i = 0; i < cols; i++) {
            Arrays.fill(this.minesArray[i], 0);
        }

        // generate random indexes for bomb placements
        // have to make sure generated placements are not repeated
        int count = 0;
        while (count < this.minecount) {
            int randomCol = (int) (Math.random() * (cols));
            int randomRow = (int) (Math.random() * (rows));
            if (this.minesArray[randomCol][randomRow] != 1) {
                this.minesArray[randomCol][randomRow] = 1;
                count++;
            }
        }
    }

    public void getGrid() {
        System.out.println();
        for (int i = 0; i < this.cols; i++) {
            for (int j = 0; j < this.rows; j++) {
                System.out.print("[" + this.minesArray[i][j] + "]");
            }
            System.out.println();
        }
    }
}
