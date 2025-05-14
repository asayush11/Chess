package src;

public class Board {
    private final Cell[] cells;

    public Board() {
        this.cells = new Cell[64];
        for(int i=0;i<64;++i){
            Cell cell = new Cell(i/8, i%8 );
            cells[i] = cell;
        }
        initializeBoard();
        System.out.println("Set up done");
    }

    private void initializeBoard() {
        // Initialize white pieces

        cells[0].setPiece(new Rook(Colour.WHITE));
        cells[1].setPiece(new Knight(Colour.WHITE));
        cells[2].setPiece(new Bishop(Colour.WHITE));
        cells[3].setPiece(new Queen(Colour.WHITE));
        cells[4].setPiece(new King(Colour.WHITE));
        cells[5].setPiece(new Bishop(Colour.WHITE));
        cells[6].setPiece(new Knight(Colour.WHITE));
        cells[7].setPiece(new Rook(Colour.WHITE));
        for (int i = 0; i < 8; i++) {
            cells[8+i].setPiece(new Pawn(Colour.WHITE));
        }

        // Initialize black pieces
        cells[56].setPiece(new Rook(Colour.BLACK));
        cells[57].setPiece(new Knight(Colour.BLACK));
        cells[58].setPiece(new Bishop(Colour.BLACK));
        cells[59].setPiece(new Queen(Colour.BLACK));
        cells[60].setPiece(new King(Colour.BLACK));
        cells[61].setPiece(new Bishop(Colour.BLACK));
        cells[62].setPiece(new Knight(Colour.BLACK));
        cells[63].setPiece(new Rook(Colour.BLACK));
        for (int i = 0; i < 8; i++) {
            cells[48+i].setPiece(new Pawn(Colour.BLACK));
        }
    }

    public Piece getPiece(int sourceRow, int sourceCol) {
        return cells[sourceCol + ( 8*sourceRow )].getPiece();
    }

    public void movePiece(int sourceRow, int sourceCol, int destRow, int destCol) {
        cells[destCol + ( 8*destRow )].setPiece(cells[sourceCol + ( 8*sourceRow )].getPiece());
        cells[sourceCol + ( 8*sourceRow )].setPiece(null);
        System.out.println(cells[destCol + ( 8*destRow )].getPiece().getColour() + " " + cells[destCol + ( 8*destRow )].getPiece().getPieceType() + " moved to " + destRow + " " + destCol);
    }

    public boolean isValidMove(int sourceRow, int sourceCol, int destRow, int destCol) {
        Cell sourceCell = cells[sourceCol + ( 8*sourceRow )];
        Cell destCell = cells[destCol + ( 8*destRow )];
        if (sourceCell.getPiece() == null || destRow < 0 || destRow > 7 || destCol < 0 || destCol > 7) {
            return false;
        }
        Piece destPiece = destCell.getPiece();
        return (destPiece == null || destPiece.getColour() != sourceCell.getPiece().getColour()) &&
                sourceCell.getPiece().canMove(destCell, sourceCell);
    }

    public void display() {
        System.out.println("Chess Board's current state");
        for(int i=0; i<8; ++i){
            System.out.printf("%nRow " + i + ":   ");
            for(int j=0;j<8;++j) {
                Piece piece = cells[8*i + j].getPiece();
                if(piece == null) System.out.print("Empty ");
                else System.out.print(piece.getColour() + " " + piece.getPieceType() + "       ");
            }
        }
    }
}
