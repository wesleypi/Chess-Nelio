package game.board;

/**
 *
 * @author WesleyPI
 */
public class BoardException extends RuntimeException{
    public BoardException (String errorMessage){
        super(errorMessage);
    }
}