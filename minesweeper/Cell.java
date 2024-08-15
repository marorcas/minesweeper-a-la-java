package minesweeper;

public class Cell {
    private int x_cord;
    private int y_cord;
    private char content;
    private boolean isRevealed;

    // --- constructor ---
    public Cell(int x_cord, int y_cord) {
        this.x_cord = x_cord;
        this.y_cord = y_cord;
        this.content = ' ';
        this.isRevealed = false;
    }

    // --- getter functions ---
    public int getXCord() {
        return this.x_cord;
    }

    public int getYCord() {
        return this.y_cord;
    }

    public char getContent() {
        return this.content;
    }

    public boolean getIsRevealed() {
        return this.isRevealed;
    }

    public boolean isBomb() {
        return false;
    }

    public char displayContent() {
        if (this.isRevealed == false) {
            return ' ';
        }

        return this.content;
    }

    // --- setter functions ---
    public void setContent(char content) {
        this.content = content;
    }

    public void setIsRevealedToTrue() {
        this.isRevealed = true;
    }
}
