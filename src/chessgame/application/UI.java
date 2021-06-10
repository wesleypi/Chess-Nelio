package chessgame.application;

import chessgame.chess.ChessPiece;

public class UI {
    public static void printBoard(ChessPiece[][] chessPieces){
        for(int i = 0; i < chessPieces.length; i++){
            System.out.print((8 - i) + " ");
            for (int j = 0; j < chessPieces[i].length ; j++){
                printPiece(chessPieces[i][j]);
            }
            System.out.println();
        }
        System.out.println("  A B C D E F G H ");
    }
    public static void printPiece(ChessPiece chessPiece) {
        if (chessPiece == null){
            System.out.print("-");
        }else{
            System.out.print(chessPiece);  
        }
        System.out.print(" ");
    }
}
