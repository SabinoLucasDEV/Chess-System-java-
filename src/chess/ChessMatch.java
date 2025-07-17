package chess;

import BoardGame.Board;
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
	
	private void  placeNewPice(char column, int row, ChessPeice piece) {
   board.placePiece(piece, new ChessPosition(column, row).toPosition());
	}
	private void initialSetup() {
		placeNewPice('c', 1, new Rook(board, Color.WHITE));
        placeNewPice('c', 2, new Rook(board, Color.WHITE));
        placeNewPice('d', 2, new Rook(board, Color.WHITE));
        placeNewPice('e', 2, new Rook(board, Color.WHITE));
        placeNewPice('e', 1, new Rook(board, Color.WHITE));
        placeNewPice('d', 1, new King(board, Color.WHITE));

        placeNewPice('c', 7, new Rook(board, Color.BLACK));
        placeNewPice('c', 8, new Rook(board, Color.BLACK));
        placeNewPice('d', 7, new Rook(board, Color.BLACK));
        placeNewPice('e', 7, new Rook(board, Color.BLACK));
        placeNewPice('e', 8, new Rook(board, Color.BLACK));
        placeNewPice('d', 8, new King(board, Color.BLACK));
		
		//board.placePiece(new Rook(board, Color.WHITE) , new Position(0, 6));
	}
 
}
