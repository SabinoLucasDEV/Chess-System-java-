package chess;

import BoardGame.Board;
import BoardGame.Position;
import chess.piece.King;
import chess.piece.Rook;

public class ChessMatch {
	
	private Board board;
	
	public ChessMatch() {
		board = new Board(8, 8);
		initialSetup();
	}
	
	public ChessPeice[][] getPieces() {
		ChessPeice[][] mat = new ChessPeice[board.getRow()][board.getColumn()];
		for (int i =0; i< board.getRow(); i++) {
			for (int j = 0; j<board.getRow(); j++) {
				mat[i][j] =(ChessPeice) board.piece(i, j);
						
						
			}
		}
		return mat;
		
	}
	private void initialSetup() {
		board.placePiece(new Rook(board, Color.WHITE), new Position(0, 0));
		board.placePiece(new King(board, Color.BLACK), new Position(0, 4));
		board.placePiece(new King(board, Color.BLACK), new Position(7, 4));
	}
 
}
