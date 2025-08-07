package chess.piece;

import BoardGame.Board;
import BoardGame.Position;
import chess.ChessPeice;
import chess.Color;

public class Bishop extends ChessPeice {
	
	public Bishop(Board board, Color color) {
		super(board, color);
	}

	@Override
	public String toString() {
		return "B";
	}
	
	@Override
	public boolean[][] possibleMoves() {
		boolean[][] mat = new boolean[getBoard().getRow()][getBoard().getColumn()];
		
		Position p = new Position(0, 0);
		
		// nw
		p.setValue(position.getRow() - 1, position.getColumn() - 1);
		while (getBoard().positionExist(p) && !getBoard().thereIsAPiece(p)) {
			mat[p.getRow()][p.getColumn()] = true;
			p.setValue(p.getRow() - 1, p.getColumn() - 1);
		}
		if (getBoard().positionExist(p) && isThereOpponentPiece(p)) {
			mat[p.getRow()][p.getColumn()] = true;
		}
		
		// ne
		p.setValue(position.getRow() - 1, position.getColumn() + 1);
		while (getBoard().positionExist(p) && !getBoard().thereIsAPiece(p)) {
			mat[p.getRow()][p.getColumn()] = true;
			p.setValue(p.getRow() - 1, p.getColumn() + 1);
		}
		if (getBoard().positionExist(p) && isThereOpponentPiece(p)) {
			mat[p.getRow()][p.getColumn()] = true;
		}
		
		// se
		p.setValue(position.getRow() + 1, position.getColumn() + 1);
		while (getBoard().positionExist(p) && !getBoard().thereIsAPiece(p)) {
			mat[p.getRow()][p.getColumn()] = true;
			p.setValue(p.getRow() + 1, p.getColumn() + 1);
		}
		if (getBoard().positionExist(p) && isThereOpponentPiece(p)) {
			mat[p.getRow()][p.getColumn()] = true;
		}
		
		// sw
		p.setValue(position.getRow() + 1, position.getColumn() - 1);
		while (getBoard().positionExist(p) && !getBoard().thereIsAPiece(p)) {
			mat[p.getRow()][p.getColumn()] = true;
			p.setValue(p.getRow() + 1, p.getColumn() - 1);
		}
		if (getBoard().positionExist(p) && isThereOpponentPiece(p)) {
			mat[p.getRow()][p.getColumn()] = true;
		}
		
		return mat;
	}

}
