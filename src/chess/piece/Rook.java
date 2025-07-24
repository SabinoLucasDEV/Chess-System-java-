package chess.piece;

import BoardGame.Board;
import BoardGame.Position;
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
	public boolean[][] possibleMoves() {
		boolean[][]  mat  = new boolean[getBoard().getRow()][getBoard().getColumn()];
		
		Position p = new Position(0, 0);
		
		//abouve 
		
		p.setValue(position.getRow() - 1, position.getColumn());
		while (getBoard().positionExist(p) && !getBoard().thereIsAPiece(p)) {
			mat[p.getRow()][p.getColumn()] = true;
			p.setRow(p.getRow() - 1);
			
			
		}
		if ( getBoard().positionExist(p) && isThereOpponentPiece(p)) {
			mat[p.getRow()][p.getColumn()] = true;
			
		}
		
	//left 
		
		p.setValue(position.getRow(), position.getColumn() - 1);
		while (getBoard().positionExist(p) && !getBoard().thereIsAPiece(p)) {
			mat[p.getRow()][p.getColumn()] = true;
			p.setColumn(p.getColumn() -1);;
			
			
		}
		if ( getBoard().positionExist(p) && isThereOpponentPiece(p)) {
			mat[p.getRow()][p.getColumn()] = true;
			
		}
		
		//right 
		
				p.setValue(position.getRow(), position.getColumn() + 1);
				while (getBoard().positionExist(p) && !getBoard().thereIsAPiece(p)) {
					mat[p.getRow()][p.getColumn()] = true;
					p.setColumn(p.getColumn() + 1);;
					
					
				}
				if ( getBoard().positionExist(p) && isThereOpponentPiece(p)) {
					mat[p.getRow()][p.getColumn()] = true;
					
				}
				//below 
				
				p.setValue(position.getRow() + 1, position.getColumn());
				while (getBoard().positionExist(p) && !getBoard().thereIsAPiece(p)) {
					mat[p.getRow()][p.getColumn()] = true;
					p.setRow(p.getRow() + 1);
					
					
				}
				if ( getBoard().positionExist(p) && isThereOpponentPiece(p)) {
					mat[p.getRow()][p.getColumn()] = true;
					
				}
				return mat;
				
		
		
		
	}
	
	

}
