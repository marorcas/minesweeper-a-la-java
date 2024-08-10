package minesweeper;

public class BombCell extends Cell {
    private boolean detonateBomb; // to keep track of whether the bomb has gone off

    public BombCell(int x_cord, int y_cord) {
        super(x_cord, y_cord);
        this.setValue(-1); // -1 represents a bomb
        this.detonateBomb = false;
    }

    public void detonateBomb() {
        this.detonateBomb = true;
    }

    @Override
    public char getValueAsChar() {
        // don't display the bomb while it's not detonated
        if (this.detonateBomb == false) {
            return ' ';
        }

        return 'X';
    }
}
