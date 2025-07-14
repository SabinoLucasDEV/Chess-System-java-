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
	
	

}
