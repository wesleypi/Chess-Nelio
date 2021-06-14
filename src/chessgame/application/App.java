/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package chessgame.application;

import chessgame.chess.ChessMatch;
import chessgame.chess.ChessPiece;
import chessgame.chess.ChessPosition;
import java.util.Scanner;

/**
 *
 * @author WesleyPI
 */

public class App {
    public static void main(String[] args) {
        Scanner scan = new Scanner (System.in);
        ChessMatch chessMatch = new ChessMatch();
        while(true){
            UI.clearScreen();
            UI.printBoard(chessMatch.getPieces());
            
            System.out.println("\nSource: ");
            ChessPosition source = UI.readChessPosition(scan);
            
            System.out.println("\nTarget: ");
            ChessPosition target = UI.readChessPosition(scan);
            
            ChessPiece capturedPiece = chessMatch.peformChessMove(source, target);
        }
        
    }
}
