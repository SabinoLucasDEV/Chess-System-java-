package chess.piece;

import BoardGame.Board;
import BoardGame.Position;
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
	private boolean canMove(Position position) {
		ChessPeice p = (ChessPeice)getBoard().piece(position);
		return p == null || p.getColor() != getColor();
	}

	@Override
	public boolean[][] possibleMoves() {
	boolean[][]  mat  = new boolean[getBoard().getRow()][getBoard().getColumn()];
	
	Position p = new Position(0,0);
	
	//Abouve 
	
	p.setValue(position.getRow() -1,position.getColumn() );
	if(getBoard().positionExist(p) && canMove(p)) {
		mat[p.getRow()][p.getColumn()] = true;
		
	}
		//below
		 
		p.setValue(position.getRow() +1,position.getColumn() );
		if(getBoard().positionExist(p) && canMove(p)) {
			mat[p.getRow()][p.getColumn()] = true;
		}
		// left
		p.setValue(position.getRow() ,position.getColumn() -1 );
		if(getBoard().positionExist(p) && canMove(p)) {
			mat[p.getRow()][p.getColumn()] = true;
		}
	
		// right
				p.setValue(position.getRow() ,position.getColumn() +1 );
				if(getBoard().positionExist(p) && canMove(p)) {
					mat[p.getRow()][p.getColumn()] = true;
				}
				
				// NW
				p.setValue(position.getRow()-1 ,position.getColumn() -1 );
				if(getBoard().positionExist(p) && canMove(p)) {
					mat[p.getRow()][p.getColumn()] = true;
				}
				
				// NE
				p.setValue(position.getRow()-1 ,position.getColumn() +1 );
				if(getBoard().positionExist(p) && canMove(p)) {
					mat[p.getRow()][p.getColumn()] = true;
				}
				
				// SW
				p.setValue(position.getRow()+1 ,position.getColumn() -1 );
				if(getBoard().positionExist(p) && canMove(p)) {
					mat[p.getRow()][p.getColumn()] = true;
				}
				// SE
				p.setValue(position.getRow()+1 ,position.getColumn() +1 );
				if(getBoard().positionExist(p) && canMove(p)) {
					mat[p.getRow()][p.getColumn()] = true;
				}
	
	
	
		return mat;
		
	}

	
}
