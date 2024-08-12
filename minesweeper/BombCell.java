package minesweeper;

public class BombCell extends Cell {
    private boolean isDetonated;

    // === constructor ===
    public BombCell(int x_cord, int y_cord) {
        super(x_cord, y_cord);
        this.setValue(-1); // -1 represents a bomb
        this.isDetonated = false;
    }

    // === getter functions ===
    @Override
    public char getValueAsChar() {
        // don't display the bomb while it's not detonated
        if (this.isDetonated == false) {
            return ' ';
        }

        return 'X';
    }

    // // === public functions ===
    public void detonateBomb() {
        this.isDetonated = true;
    }
}
