package chess.piece;

import BoardGame.Board;
import BoardGame.Position;
import chess.ChessPeice;
import chess.Color;

public class Knight  extends  ChessPeice {

	public Knight(Board board, Color color) {
		super(board, color);
	}

	@Override
	public String toString() {
		return "N";
	}

	private boolean canMove(Position position) {
		ChessPeice p = (ChessPeice)getBoard().piece(position);
		return p == null || p.getColor() != getColor();
	}
	
	@Override
	public boolean[][] possibleMoves() {
		boolean[][] mat = new boolean[getBoard().getRow()][getBoard().getColumn()];
		
		Position p = new Position(0, 0);
		
		p.setValue(position.getRow() - 1, position.getColumn() - 2);
		if (getBoard().positionExist(p) && canMove(p)) {
			mat[p.getRow()][p.getColumn()] = true;
		}

		p.setValue(position.getRow() - 2, position.getColumn() - 1);
		if (getBoard().positionExist(p) && canMove(p)) {
			mat[p.getRow()][p.getColumn()] = true;
		}

		p.setValue(position.getRow() - 2, position.getColumn() + 1);
		if (getBoard().positionExist(p) && canMove(p)) {
			mat[p.getRow()][p.getColumn()] = true;
		}

		p.setValue(position.getRow() - 1, position.getColumn() + 2);
		if (getBoard().positionExist(p) && canMove(p)) {
			mat[p.getRow()][p.getColumn()] = true;
		}

		p.setValue(position.getRow() + 1, position.getColumn() + 2);
		if (getBoard().positionExist(p) && canMove(p)) {
			mat[p.getRow()][p.getColumn()] = true;
		}

		p.setValue(position.getRow() + 2, position.getColumn() + 1);
		if (getBoard().positionExist(p) && canMove(p)) {
			mat[p.getRow()][p.getColumn()] = true;
		}

		p.setValue(position.getRow() + 2, position.getColumn() - 1);
		if (getBoard().positionExist(p) && canMove(p)) {
			mat[p.getRow()][p.getColumn()] = true;
		}
		
		p.setValue(position.getRow() + 1, position.getColumn() - 2);
		if (getBoard().positionExist(p) && canMove(p)) {
			mat[p.getRow()][p.getColumn()] = true;
		}

		return mat;
	}
}
