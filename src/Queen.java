package src;

public class Queen extends Piece {
    public Queen(Colour color) {
        super(color, PieceType.QUEEN);
    }

    @Override
    public boolean canMove(Cell newCell, Cell curCell) {
        int rowDiff = Math.abs(curCell.getRow() - newCell.getRow());
        int colDiff = Math.abs(curCell.getCol() - newCell.getCol());
        return ( (rowDiff == colDiff) || (curCell.getRow() == newCell.getRow() || curCell.getCol() == newCell.getCol()) );
    }
}
