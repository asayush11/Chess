package src;

public abstract class Piece {
    protected final Colour color;
    protected final PieceType pieceType;

    public Piece(Colour color, PieceType pieceType) {
        this.pieceType = pieceType;
        this.color = color;
    }

    public abstract boolean canMove(Cell newCell, Cell curCell);

    public Colour getColour() {
        return color;
    }

    public PieceType getPieceType() {
        return pieceType;
    }
}
