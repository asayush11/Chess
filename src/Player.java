package src;

public class Player {
    private final Colour color;

    public Player(Colour color) {
        this.color = color;
    }

    public Colour getColour() {
        return color;
    }

    public boolean makeMove(Board board, int sourceRow, int sourceCol, int destRow, int destCol) {
        if (board.isValidMove(sourceRow, sourceCol, destRow, destCol)) {
           board.movePiece(sourceRow, sourceCol, destRow, destCol);
           return true;
        } else {
            System.out.println("Invalid move!");
            return false;
        }
    }
}
