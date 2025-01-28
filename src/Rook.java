package src;

public class Rook extends Piece {
    public Rook(Colour color) {
        super(color, PieceType.ROOK);
    }

    @Override
    public boolean canMove(Cell newCell, Cell curCell) {
        return (curCell.getRow() == newCell.getRow() || curCell.getCol() == newCell.getCol());
    }
}
