package minesweeper;

public class BombCell extends Cell {
    private char content;
    private boolean isDetonated;

    // --- constructor ---
    public BombCell(int x_cord, int y_cord) {
        super(x_cord, y_cord);
        this.content = 'X';
        this.isDetonated = false;
    }

    // --- setter functions ---
    public void detonateBomb() {
        this.isDetonated = true;
    }

    // --- public functions ---
    @Override
    public char displayContent() {
        // don't display the bomb while it's not detonated
        if (this.isDetonated == false) {
            return ' ';
        }

        return this.content;
    }

    @Override
    public boolean isBomb() {
        return true;
    }
}
