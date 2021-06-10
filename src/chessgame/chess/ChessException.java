/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package chessgame.chess;

/**
 *
 * @author WesleyPI
 */
public class ChessException extends RuntimeException{
    public ChessException (String errorMessage){
        super(errorMessage);
    }
}
