package chessgame.chess;

import game.board.Position;

/**
 *
 * @author WesleyPI
 */
public class ChessPosition {
    private char column;
    private int row;
        
    public ChessPosition(char column,int row) {
        if (row < 1 || row > 8 && column < 'A' || column > 'H'){
            throw new ChessException("Error instantiating ChessPosition. Valid values are from A1 to H8.");
        }
        this.row = row;
        this.column = column;
    }

    public int getRow() {
        return row;
    }

    public char getColumn() {
        return column;
    }
    
    protected Position toPosition(){
        return new Position (8 - row, column - 'A');
    }
    
    protected static ChessPosition fromPosition (Position position){
        return new ChessPosition ((char)('A' - position.getColumn()), 8 - position.getRow());
    }

    @Override
    public String toString() {
        return ""+ column + row;
    }
}