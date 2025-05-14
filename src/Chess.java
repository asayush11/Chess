package src;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Scanner;

public class Chess {
    private final Board board;
    private final Deque<Player> players;

    public Chess() {
        board = new Board();
        players = new ArrayDeque<>();
        players.add(new Player(Colour.WHITE));
        players.addLast(new Player(Colour.BLACK));
        board.display();
    }

    public void start() {
        var attempts = 0;
        // Game loop
        do {
            Player player = players.getFirst();
            players.pop();
            players.addLast(player);
            System.out.println(player.getColour() + "'s turn.");

            int played = 0;
            while(played < 3) {
                ++played;
                if(getPlayerMove(player)) played = 10;
            }
            board.display();
            if(played == 3) {
                System.out.println(players.getFirst().getColour() + " won");
                return;
            }
            attempts++;

        } while (attempts < 2);
        System.out.println("Timeout!");
        board.display();
    }

    private boolean getPlayerMove(Player player) {
        // For simplicity, let's assume the player enters the move via console input
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter source row: ");
        int sourceRow = scanner.nextInt();
        System.out.print("Enter source column: ");
        int sourceCol = scanner.nextInt();
        System.out.print("Enter destination row: ");
        int destRow = scanner.nextInt();
        System.out.print("Enter destination column: ");
        int destCol = scanner.nextInt();

        Piece piece = board.getPiece(sourceRow, sourceCol);
        if (piece == null || piece.getColour() != player.getColour()) {
            System.out.println("Invalid piece selection!");
            return false;
        }
        return player.makeMove(this.board, sourceRow, sourceCol, destRow, destCol);
    }

}
