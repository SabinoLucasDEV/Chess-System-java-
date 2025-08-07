package chess;

import BoardGame.Board;
import BoardGame.Piece;
import BoardGame.Position;

public abstract class ChessPeice extends Piece {
	private Color color;
	private int moveCount;

	public ChessPeice(Board board, Color color) {
		super(board);
		this.color = color;
	}
	
	public int getMoveCount() {
		return moveCount;
	}

	public Color getColor() {
		return color;
	}
	public int increaseMoveCount() {
	return 	moveCount++;
	}
	
	public int decreaseMoveCount() {
		return 	moveCount--;
		}
	
	public ChessPosition getChessPosition () {
	return  ChessPosition.fromPosition(position);
	
	}
	
	protected Boolean isThereOpponentPiece(Position position) {
		ChessPeice p = (ChessPeice)getBoard().piece(position);
		return p != null && p.getColor() != color; 
	}


	

	

}
