/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package chessgame.chesspieces;

import game.board.Board;
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

    @Override
    public boolean[][] possibleMoves() {
       boolean[][] mat = new boolean [getBoard().getRows()][getBoard().getColumns()];
       return mat; 
    }
}
