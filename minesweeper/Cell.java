package minesweeper;

public class Cell {
    private int x_cord;
    private int y_cord;
    private int value;

    public Cell(int x_cord, int y_cord) {
        this.x_cord = x_cord;
        this.y_cord = y_cord;
        this.value = -2;
    }

    // getter functions
    public int getXCord() {
        return this.x_cord;
    }

    public int getYCord() {
        return this.y_cord;
    }

    public int getValue() {
        return this.value;
    }

    // setter functions
    public void setValue(int value) {
        this.value = value;
    }

    public char getValueAsChar() {
        if (this.getValue() == -2) {
            return ' ';
        }

        // turn int value into a char
        return (char) (this.getValue() + '0');
    }
}
