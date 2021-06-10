/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package chessgame.board;

import chessgame.chess.chesspieces.Rook;

/**
 *
 * @author WesleyPIs
 */
public class Board {
    private int rows, columns;
    private Piece[][] pieces;
    
    public Board(int rows, int columns){
        this.rows = rows;
        this.columns = columns;
        pieces = new Piece[rows][columns];
    }

    /**
     * @return the rows
     */
    public int getRows() {
        return rows;
    }

    /**
     * @return the columns
     */
    public int getColumns() {
        return columns;
    }
    public Piece piece(int row, int column){
        return pieces[row][column];
    }
    public Piece piece(Position position){
        return pieces[position.getRow()][position.getColumn()];
    }
    
    public void placePiece(Piece piece, Position position){
        pieces[position.getRow()][position.getColumn()] = piece;
        piece.position = position;
    }
}
