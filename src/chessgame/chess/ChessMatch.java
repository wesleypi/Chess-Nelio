package chessgame.chess;

import chessgame.board.Board;
import chessgame.chess.chesspieces.King;
import chessgame.chess.chesspieces.Rook;

public class ChessMatch{
    private Board board;

    public ChessMatch() {
        board = new Board(8,8);
        initialSetup();
    }
    
    public ChessPiece[][] getPieces(){
        ChessPiece[][] mat = new ChessPiece[board.getRows()][board.getColumns()];
        for (int i = 0; i < board.getRows(); i++) {
            for (int j = 0; j < board.getColumns(); j++){
                mat[i][j] = (ChessPiece) board.piece(i,j);
            }
        }
        return mat;
    }
    private void placeNewPiece(char column, int row, ChessPiece piece){
        board.placePiece(piece, new ChessPosition(column, row).toPosition());
    }
    private void initialSetup(){
        // Blacks
        placeNewPiece('A',8,new Rook(board, Color.BLACK));
        placeNewPiece('H',8,new Rook(board, Color.BLACK));
        placeNewPiece('E',8,new King(board, Color.BLACK));
        
        //Whites
        placeNewPiece('A',1,new Rook(board, Color.WHITE));
        placeNewPiece('H',1,new Rook(board, Color.WHITE));
        placeNewPiece('E',1,new King(board, Color.WHITE));
    }
}