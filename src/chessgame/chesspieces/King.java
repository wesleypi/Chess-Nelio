/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package chessgame.chesspieces;

import game.board.Board;
import chessgame.chess.ChessPiece;
import chessgame.chess.Color;
import game.board.Position;

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
    public boolean isThereOpponentPiece(Position position){
        ChessPiece aux = (ChessPiece) getBoard().piece(position);
        return aux == null || aux.getColor()!= getColor();
    }
    
    @Override
    public boolean[][] possibleMoves() {
       boolean[][] mat = new boolean [getBoard().getRows()][getBoard().getColumns()];
       Position auxPosition = new Position (0,0);
       
       // above
       auxPosition.setRowColumn(position.getRow() - 1, position.getColumn());
       if (getBoard().positionExists(auxPosition) && isThereOpponentPiece(auxPosition)){
           mat[auxPosition.getRow()][auxPosition.getColumn()] = true;
       }
       // below
       auxPosition.setRowColumn(position.getRow() + 1, position.getColumn());
       if (getBoard().positionExists(auxPosition) && isThereOpponentPiece(auxPosition)){
           mat[auxPosition.getRow()][auxPosition.getColumn()] = true;
       }
       // left
       auxPosition.setRowColumn(position.getRow() , position.getColumn() -1);
       if (getBoard().positionExists(auxPosition) && isThereOpponentPiece(auxPosition)){
           mat[auxPosition.getRow()][auxPosition.getColumn()] = true;
       }
       // right
       auxPosition.setRowColumn(position.getRow() , position.getColumn() +1);
       if (getBoard().positionExists(auxPosition) && isThereOpponentPiece(auxPosition)){
           mat[auxPosition.getRow()][auxPosition.getColumn()] = true;
       }
       // NW
       auxPosition.setRowColumn(position.getRow()-1 , position.getColumn() -1);
       if (getBoard().positionExists(auxPosition) && isThereOpponentPiece(auxPosition)){
           mat[auxPosition.getRow()][auxPosition.getColumn()] = true;
       }
       // NE
       auxPosition.setRowColumn(position.getRow()-1 , position.getColumn() +1);
       if (getBoard().positionExists(auxPosition) && isThereOpponentPiece(auxPosition)){
           mat[auxPosition.getRow()][auxPosition.getColumn()] = true;
       }
       //SW
       auxPosition.setRowColumn(position.getRow()+1 , position.getColumn() -1);
       if (getBoard().positionExists(auxPosition) && isThereOpponentPiece(auxPosition)){
           mat[auxPosition.getRow()][auxPosition.getColumn()] = true;
       }
       // SE
       auxPosition.setRowColumn(position.getRow()+1 , position.getColumn() +1);
       if (getBoard().positionExists(auxPosition) && isThereOpponentPiece(auxPosition)){
           mat[auxPosition.getRow()][auxPosition.getColumn()] = true;
       }
       
       return mat; 
    }
}
