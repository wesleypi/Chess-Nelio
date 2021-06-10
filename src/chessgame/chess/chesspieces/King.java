/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package chessgame.chess.chesspieces;

import chessgame.board.Board;
import chessgame.chess.ChessPiece;
import chessgame.chess.Color;

/**
 *
 * @author WesleyPI
 */
public class King extends ChessPiece{
    
    public King(Board board, Color color) {
        super(board, color);
    }
    
    @Override
    public String toString(){
        return "K";
    }
}
