package src;

public class Pawn extends Piece {
    public Pawn(Colour color) {
        super(color, PieceType.PAWN);
    }

    @Override
    public boolean canMove(Cell newCell, Cell curCell) {
        int rowDiff = newCell.getRow() - curCell.getRow();
        int colDiff = Math.abs(curCell.getCol() - newCell.getCol());

        if (color == Colour.WHITE) {
            return (rowDiff == 1 && colDiff == 0) ||
                    (curCell.getRow() == 1 && rowDiff == 2 && colDiff == 0) ||
                    (rowDiff == 1 && colDiff == 1 && newCell.getPiece() != null);
        } else {
            return (rowDiff == -1 && colDiff == 0) ||
                    (curCell.getRow() == 6 && rowDiff == -2 && colDiff == 0) ||
                    (rowDiff == -1 && colDiff == 1 && newCell.getPiece() != null);
        }
    }
}
