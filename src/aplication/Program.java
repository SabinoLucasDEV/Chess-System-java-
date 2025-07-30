package aplication;

import java.util.InputMismatchException;
import java.util.Scanner;

import chess.ChessExcepition;
import chess.ChessMatch;
import chess.ChessPeice;
import chess.ChessPosition;

public class Program {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		ChessMatch chessMatch = new ChessMatch();
		
		while(true) {
			try {
				
			UI.clearScreen();
			UI.printBoard(chessMatch.getPieces());
			System.out.println();
			System.out.println("Source: ");
			ChessPosition source = UI.readChessPossition(sc);
			boolean[][] possibleMoves = chessMatch.possiblemoves(source);
			
			UI.clearScreen();
			UI.printBoard(chessMatch.getPieces(), possibleMoves);
			
			System.out.println();
			System.out.println("Target");
			ChessPosition target  = UI.readChessPossition(sc);
			
			boolean[][] possiblemoves = chessMatch.possiblemoves(source);
			UI.clearScreen();
			UI.printBoard(ChessMatch.getPieces(), possiblemoves);
			
			ChessPeice capturedPiece = chessMatch.perforChessMove(source, target);
			}
			catch (ChessExcepition e) {
				System.out.println(e.getMessage());
				sc.nextLine();
			}
			catch (InputMismatchException e) {
				System.out.println(e.getMessage());
				sc.nextLine();
			}
			
			
			}

	}

}
