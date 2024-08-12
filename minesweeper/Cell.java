package minesweeper;

public class Cell {
    private int x_cord;
    private int y_cord;
    private int value;
    private boolean isRevealed;

    // === constructor ===
    public Cell(int x_cord, int y_cord) {
        this.x_cord = x_cord;
        this.y_cord = y_cord;
        this.value = -2; // -2 represents an empty cell
        this.isRevealed = false;
    }

    // === getter functions ===
    public int getXCord() {
        return this.x_cord;
    }

    public int getYCord() {
        return this.y_cord;
    }

    public int getValue() {
        return this.value;
    }

    public boolean getIsRevealed() {
        return this.isRevealed;
    }

    public char getValueAsChar() {
        if (this.isRevealed == false) {
            return ' ';
        }

        // turn int value into a char
        return (char) (this.getValue() + '0');
    }

    // === setter functions ===
    public void setValue(int value) {
        this.value = value;
    }

    public void setIsRevealedToTrue() {
        this.isRevealed = true;
    }
}
