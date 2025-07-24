package chess;

import BoardGame.Board;
import BoardGame.Piece;
import BoardGame.Position;

public abstract class ChessPeice extends Piece {
	private Color color;

	public ChessPeice(Board board, Color color) {
		super(board);
		this.color = color;
	}

	public Color getColor() {
		return color;
	}
	protected Boolean isThereOpponentPiece(Position position) {
		ChessPeice p = (ChessPeice)getBoard().piece(position);
		return p != null && p.getColor() != color; 
	}


	

	

}
