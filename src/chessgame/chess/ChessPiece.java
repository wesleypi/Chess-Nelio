package chessgame.chess;

import game.board.Board;
import game.board.Piece;
import game.board.Position;

public abstract class ChessPiece extends Piece {
    private final Color color;
    
    public ChessPiece (Board board, Color color){
        super (board);
        this.color = color;
    }

    public Color getColor() {
        return color;
    }
    
    public boolean isThereOpponentPiece(Position position){
        ChessPiece aux = (ChessPiece) getBoard().piece(position);
        return aux != null && aux.getColor()!= this.color;
    }
}