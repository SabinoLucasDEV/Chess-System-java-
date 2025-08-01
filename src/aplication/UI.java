package aplication;

import java.util.InputMismatchException;
import java.util.Scanner;

import chess.ChessMatch;
import chess.ChessPeice;
import chess.ChessPosition;
import chess.Color;

public class UI {

	public static final String ANSI_RESET = "\u001B[0m";
	public static final String ANSI_BLACK = "\u001B[30m";
	public static final String ANSI_RED = "\u001B[31m";
	public static final String ANSI_GREEN = "\u001B[32m";
	public static final String ANSI_YELLOW = "\u001B[33m";
	public static final String ANSI_BLUE = "\u001B[34m";
	public static final String ANSI_PURPLE = "\u001B[35m";
	public static final String ANSI_CYAN = "\u001B[36m";
	public static final String ANSI_WHITE = "\u001B[37m";

	public static final String ANSI_BLACK_BACKGROUND = "\u001B[40m";
	public static final String ANSI_RED_BACKGROUND = "\u001B[41m";
	public static final String ANSI_GREEN_BACKGROUND = "\u001B[42m";
	public static final String ANSI_YELLOW_BACKGROUND = "\u001B[43m";
	public static final String ANSI_BLUE_BACKGROUND = "\u001B[44m";
	public static final String ANSI_PURPLE_BACKGROUND = "\u001B[45m";
	public static final String ANSI_CYAN_BACKGROUND = "\u001B[46m";
	public static final String ANSI_WHITE_BACKGROUND = "\u001B[47m";
	
	// https://stackoverflow.com/questions/2979383/java-clear-the-console
	public static void clearScreen() {
	 System.out.print("\033[H\033[2J");
	 System.out.flush();
	} 
	
	public static ChessPosition readChessPossition(Scanner sc ) {
		try {
		String s = sc.nextLine();
		char column = s.charAt(0);
		int row = Integer.parseInt(s.substring(1));
		return new ChessPosition(column, row);
		}
		catch (RuntimeException e) {
			throw new InputMismatchException("erro ao inserir um dado");
			
		}
		
	
	}

	public static void printBoard(ChessPeice[][] piece) {
		for (int i = 0; i < piece.length; i++) {
			System.out.print(8 - i + " ");

			for (int j = 0; j < piece.length; j++) {
				printPiece(piece[i][j], false);
			}
			System.out.println();

		}
		System.out.println("  a b c d e f g h ");

	}
	
	public static void printBoard(ChessPeice[][] piece, boolean[][] possibleMoves) {
		for (int i = 0; i < piece.length; i++) {
			System.out.print(8 - i + " ");

			for (int j = 0; j < piece.length; j++) {
				printPiece(piece[i][j], possibleMoves[i][j]);
			}
			System.out.println();

		}
		System.out.println("  a b c d e f g h ");
		System.out.println();

	}
	
	public static void printMatch(ChessMatch chess) {
		printBoard(chess.getPieces());
		System.out.println();
		System.out.println("turn  : " + chess.getTurn());
		System.out.println("wating player: " +  chess.getCurrentPlayer());
		
	}

	private static void printPiece(ChessPeice piece, boolean backgroung) {
        if (backgroung) {
        	System.out.print(ANSI_GREEN);
        }
		
		
		if (piece == null) {
            System.out.print("-" + ANSI_RESET);
        }
        else {
            if (piece.getColor() == Color.WHITE) {
                System.out.print(ANSI_WHITE + piece + ANSI_RESET);
            }
            else {
                System.out.print(ANSI_YELLOW + piece + ANSI_RESET);
            }
        }
        System.out.print(" ");
	}

}
