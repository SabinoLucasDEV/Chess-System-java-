package chess.piece;

import BoardGame.Board;
import chess.ChessPeice;
import chess.Color;

public  class King extends ChessPeice {

	public King(Board board, Color color) {
		super(board, color);
		
	}

	@Override
	public String toString() {
		return "K";
	}

	@Override
	public Boolean[][] possibleMoves() {
	Boolean[][]  mat  = new Boolean[getBoard().getRow()][getBoard().getColumn()];
		return mat;
		
	}

	
}
