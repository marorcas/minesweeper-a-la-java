package minesweeper;

public class BombCell extends Cell {
    private boolean detonateBomb; // to keep track of whether the bomb has gone off

    // === constructor ===
    public BombCell(int x_cord, int y_cord) {
        super(x_cord, y_cord);
        this.setValue(-1); // -1 represents a bomb
        this.detonateBomb = false;
    }

    // === getter functions ===
    @Override
    public char getValueAsChar() {
        // don't display the bomb while it's not detonated
        if (this.detonateBomb == false) {
            return ' ';
        }

        return 'X';
    }

    // === public functions ===
    public void detonateBomb() {
        this.detonateBomb = true;
    }
}
