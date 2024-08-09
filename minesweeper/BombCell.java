package minesweeper;

public class BombCell extends Cell {

    public BombCell(int x_cord, int y_cord) {
        super(x_cord, y_cord);
        this.setValue(-1);
    }

    @Override
    public char getValueAsChar() {
        return 'x';
    }
}
