package chess.piece;

import BoardGame.Board;
import chess.ChessPeice;
import chess.Color;

public class Rook extends ChessPeice {

	public Rook(Board board, Color color) {
		super(board, color);
		
	}

	@Override
	public String toString() {
		return "R";
	}

	@Override
	public Boolean[][] possibleMoves() {
		Boolean[][]  mat  = new Boolean[getBoard().getRow()][getBoard().getColumn()];
		return mat;
	}
	
	

}
