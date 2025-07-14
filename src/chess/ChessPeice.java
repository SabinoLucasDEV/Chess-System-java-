package chess;

import BoardGame.Board;
import BoardGame.Piece;

public class ChessPeice extends Piece {
	private Color color;

	public ChessPeice(Board board, Color color) {
		super(board);
		this.color = color;
	}
	

	

}
