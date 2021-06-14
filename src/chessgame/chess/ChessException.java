/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package chessgame.chess;

import chessgame.board.BoardException;

/**
 *
 * @author WesleyPI
 */
public class ChessException extends BoardException{
    public ChessException (String errorMessage){
        super(errorMessage);
    }
}
