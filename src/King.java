package src;

public class King extends Piece {
    public King(Colour color) {
        super(color, PieceType.KING);
    }

    @Override
    public boolean canMove(Cell newCell, Cell curCell) {
        int rowDiff = Math.abs(curCell.getRow() - newCell.getRow());
        int colDiff = Math.abs(curCell.getCol() - newCell.getCol());
        return (rowDiff <= 1 && colDiff <= 1);
    }
}
