package chessgame.chess;

import game.board.Board;
import game.board.Piece;
import game.board.Position;
import chessgame.chesspieces.King;
import chessgame.chesspieces.Rook;

public class ChessMatch{
    private final Board board;
    private Color currentPlayer;
    private int turn;

    public ChessMatch() {
        board = new Board(8,8);
        turn = 1;
        currentPlayer = Color.WHITE;
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
    
    public boolean[][] possibleMoves(ChessPosition source){
        Position position = source.toPosition();
        validateSourcePosition(position);
        return board.piece(position).possibleMoves();
    }
    
    public ChessPiece peformChessMove(ChessPosition sourcePosition, ChessPosition targetPosition){
        Position source = sourcePosition.toPosition();
        Position target = targetPosition.toPosition();
        validadeTargetPosition(source,target);
        validateSourcePosition(source);
        Piece capturedPiece = makeMove(source, target);
        nextTurn();
        return (ChessPiece) capturedPiece;
        
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

    private void validateSourcePosition(Position position) {
        if (!board.thereIsAPiece(position)){
            throw new ChessException("There is no piece on source position");
        }
        if (currentPlayer != ((ChessPiece) board.piece(position)).getColor()){
            throw  new ChessException("the chosen piece is not yours");
        }
        if (!board.piece(position).isThereAnyPossibleMove()){
            throw new ChessException("There is no possible moves for the chosen piece");
        }
        
    }
    private void validadeTargetPosition(Position source, Position target) {
        if (!board.piece(source).possibleMove(target)){
            throw new ChessException ("The chosen piece can't move to target position");
        }
    }
    private void nextTurn(){
        turn++;
        currentPlayer = (currentPlayer == Color.WHITE) ? Color.BLACK : Color.WHITE;
    }

    private Piece makeMove(Position source, Position target) {
        Piece p = board.removePiece(source);
        Piece capturedPiece = board.removePiece(target);
        board.placePiece(p, target);
        return capturedPiece;
    }


    public Color getCurrentPlayer() {
        return currentPlayer;
    }

    public int getTurn() {
        return turn;
    }
}