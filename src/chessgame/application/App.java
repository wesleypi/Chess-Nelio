package chessgame.application;

import chessgame.chess.ChessException;
import chessgame.chess.ChessMatch;
import chessgame.chess.ChessPiece;
import chessgame.chess.ChessPosition;

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

/**
 *
 * @author WesleyPI
 */
public class App {

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        ChessMatch chessMatch = new ChessMatch();
        List<ChessPiece> captured = new ArrayList<>();
        while (true) {
            try {
                UI.clearScreen();
                UI.printMatch(chessMatch, captured);

                System.out.println("\nSource: ");
                ChessPosition source = UI.readChessPosition(scan);
                boolean[][] possibleMoves = chessMatch.possibleMoves(source);
                
                UI.clearScreen();
                UI.printBoard(chessMatch.getPieces(), possibleMoves);

                System.out.println("\nTarget: ");
                ChessPosition target = UI.readChessPosition(scan);

                
                ChessPiece capturedPiece = chessMatch.peformChessMove(source, target);

                if (capturedPiece != null){
                    captured.add(capturedPiece);
                }

            } catch (ChessException | InputMismatchException e) {
                System.out.println(e.getMessage());
                scan.nextLine();
            }
            
        }
    }
}
