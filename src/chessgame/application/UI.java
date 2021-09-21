package chessgame.application;

import chessgame.chess.ChessMatch;
import chessgame.chess.ChessPiece;
import chessgame.chess.ChessPosition;
import chessgame.chess.Color;

import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class UI {

    // https://stackoverflow.com/questions/5762491/how-to-print-color-in-console-using-system-out-println
    public static final String ANSI_RESET = "\u001B[0m";
    public static final String ANSI_BLACK = "\u001B[30m";
    public static final String ANSI_RED = "\u001B[31m";
    public static final String ANSI_GREEN = "\u001B[32m";
    public static final String ANSI_YELLOW = "\u001B[33m";
    public static final String ANSI_BLUE = "\u001B[34m";
    public static final String ANSI_PURPLE = "\u001B[35m";
    public static final String ANSI_CYAN = "\u001B[36m";
    public static final String ANSI_WHITE = "\u001B[37m";

    public static final String ANSI_BLACK_BACKGROUND = "\u001B[40m";
    public static final String ANSI_RED_BACKGROUND = "\u001B[41m";
    public static final String ANSI_GREEN_BACKGROUND = "\u001B[42m";
    public static final String ANSI_YELLOW_BACKGROUND = "\u001B[43m";
    public static final String ANSI_BLUE_BACKGROUND = "\u001B[44m";
    public static final String ANSI_PURPLE_BACKGROUND = "\u001B[45m";
    public static final String ANSI_CYAN_BACKGROUND = "\u001B[46m";
    public static final String ANSI_WHITE_BACKGROUND = "\u001B[47m";

    // https://stackoverflow.com/questions/2979383/java-clear-the-console
    public static void clearScreen() {
        System.out.print("\033[H\033[2J");
        System.out.flush();
    }

    public static ChessPosition readChessPosition(Scanner scan) {
        try {
            String str = scan.nextLine();
            char column = str.toUpperCase().charAt(0);
            int row = Integer.parseInt(str.substring(1));
            return new ChessPosition(column, row);
        } catch (RuntimeException e) {
            throw new InputMismatchException("Error reading ChessPosition. valid values are from A1 to H8");
        }
    }

    public static void printBoard(ChessPiece[][] chessPieces) {
        for (int i = 0; i < chessPieces.length; i++) {
            System.out.print((8 - i) + " ");
            for (ChessPiece chessPiece : chessPieces[i]) {
                printPiece(chessPiece, false);
            }
            System.out.println();
        }
        System.out.println("  A B C D E F G H ");
    }
    public static void printMatch(ChessMatch chessMatch, List<ChessPiece> captured){
        printBoard(chessMatch.getPieces());
        printCapturedPieces(captured);
        System.out.println("\nTurn : "+chessMatch.getTurn());
        System.out.println("waiting player : "+chessMatch.getCurrentPlayer());
    }

    public static void printBoard(ChessPiece[][] chessPieces, boolean[][] possibleMoves) {
        for (int i = 0; i < chessPieces.length; i++) {
            System.out.print((8 - i) + " ");
            for (int j = 0; j < chessPieces[i].length;j++){
                printPiece(chessPieces[i][j], possibleMoves[i][j]);
            }
            System.out.println();
        }
        System.out.println("  A B C D E F G H ");
    }

    public static void printPiece(ChessPiece chessPiece, boolean backColor) {
        if (backColor){
            System.out.print(ANSI_YELLOW_BACKGROUND);
        }
        if (chessPiece == null) {
            System.out.print("-" + ANSI_RESET);
        } else {
            if (chessPiece.getColor() == Color.WHITE) {
                System.out.print(ANSI_WHITE + chessPiece + ANSI_RESET);
            } else {
                System.out.print(ANSI_BLUE + chessPiece + ANSI_RESET);
            }
        }
        System.out.print(" ");
    }
    public static void printCapturedPieces(List<ChessPiece> pieces){
        List<ChessPiece> white = pieces.stream().filter(p ->  p.getColor()==Color.WHITE).collect(Collectors.toList());
        List<ChessPiece> black = pieces.stream().filter(p -> p.getColor()==Color.BLACK).collect(Collectors.toList());
        System.out.println("\nCaptured Pieces");
        System.out.println(ANSI_WHITE+"White: "+ Arrays.toString(white.toArray())+ANSI_RESET);
        System.out.println(ANSI_BLUE+"Black: "+ Arrays.toString(black.toArray())+ANSI_RESET);
    }
}