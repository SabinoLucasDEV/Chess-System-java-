package aplication;

import java.util.Scanner;

import chess.ChessMatch;
import chess.ChessPeice;
import chess.ChessPosition;

public class Program {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		ChessMatch chessMatch = new ChessMatch();
		
		while(true) {
			UI.printBoard(chessMatch.getPieces());
			System.out.println();
			System.out.println("Source: ");
			ChessPosition source = UI.readChessPossition(sc);
			
			System.out.println();
			System.out.println("Target");
			ChessPosition target  = UI.readChessPossition(sc);
			
			ChessPeice capturedPiece = chessMatch.perforChessMove(source, target);
		}

	}

}
