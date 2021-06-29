package chessgame.application;

import chessgame.chess.ChessException;
import chessgame.chess.ChessMatch;
import chessgame.chess.ChessPiece;
import chessgame.chess.ChessPosition;
import java.util.InputMismatchException;
import java.util.Scanner;

/**
 *
 * @author WesleyPI
 */
public class App {

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        ChessMatch chessMatch = new ChessMatch();
        while (true) {
            try {
                UI.clearScreen();
                UI.printBoard(chessMatch.getPieces());

                System.out.println("\nSource: ");
                ChessPosition source = UI.readChessPosition(scan);
                boolean[][] possibleMoves = chessMatch.possibleMoves(source);
                
                UI.clearScreen();
                UI.printBoard(chessMatch.getPieces(), possibleMoves);

                System.out.println("\nTarget: ");
                ChessPosition target = UI.readChessPosition(scan);

                
                ChessPiece capturedPiece = chessMatch.peformChessMove(source, target);
            } catch (ChessException | InputMismatchException e) {
                System.out.println(e.getMessage());
                scan.nextLine();
            }
        }
    }
}
