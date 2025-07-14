package aplication;

import BoardGame.Piece;
import chess.ChessPeice;

public class UI {
	public static void printBoard(ChessPeice[][] piece) {
		for (int i =0; i< piece.length; i++) {
			System.out.print(8 - i + " ");
			
			for (int j = 0; j < piece.length ; j++) {
				printPiece(piece[i][j]);
			}
			System.out.println();
				
		}
		System.out.println("  a b c d e f g h ");
		
		
	}
	private static void printPiece(ChessPeice piece) {
		if (piece == null) {
			
			System.out.print("-");
			
		}
		else {
			System.out.print(piece);
		}
		System.out.print(" ");
	}

}
