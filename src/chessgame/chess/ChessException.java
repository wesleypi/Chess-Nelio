package chessgame.chess;

import game.board.BoardException;

/**
 *
 * @author WesleyPI
 */
public class ChessException extends BoardException{
    public ChessException (String errorMessage){
        super(errorMessage);
    }
}