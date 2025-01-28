package src;

public class Bishop extends Piece {
    public Bishop(Colour color) {
        super(color, PieceType.BISHOP);
    }

    @Override
    public boolean canMove(Cell newCell, Cell curCell) {
        int rowDiff = Math.abs(curCell.getRow() - newCell.getRow());
        int colDiff = Math.abs(curCell.getCol() - newCell.getCol());
        return (rowDiff == colDiff);
    }
}
