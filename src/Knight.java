package src;

public class Knight extends Piece {
    public Knight(Colour color) {
        super(color, PieceType.KNIGHT);
    }

    @Override
    public boolean canMove(Cell newCell, Cell curCell) {
        int rowDiff = Math.abs(curCell.getRow() - newCell.getRow());
        int colDiff = Math.abs(curCell.getCol() - newCell.getCol());
        return (rowDiff == 2 && colDiff == 1) || (rowDiff == 1 && colDiff == 2);
    }
}
