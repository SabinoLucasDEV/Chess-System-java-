package chess;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import BoardGame.Board;
import BoardGame.Piece;
import BoardGame.Position;
import chess.piece.King;
import chess.piece.Rook;

public class ChessMatch {
	
	private int turn;
	private Color currentPlayer;
	private static Board board;
	private boolean check;
	private boolean checkMate;
	
	
	
	private List<Piece> pieceOnTheBoard = new ArrayList<>();
	private List<Piece> capturedPiece = new ArrayList<>();
	
	public ChessMatch() {
		board = new Board(8, 8);
		turn = 1;
		currentPlayer = Color.WHITE;
		initialSetup();
	}
	
	public boolean getCheckMate() {
		return checkMate;
		
	}
	public boolean getCheck() {
		return check;
	}
	
	public int getTurn() {
		return turn;
	}
	
	public Color getCurrentPlayer() {
		return currentPlayer;
	}
	
	public static ChessPeice[][] getPieces() {
		ChessPeice[][] mat = new ChessPeice[board.getRow()][board.getColumn()];
		for (int i =0; i< board.getRow(); i++) {
			for (int j = 0; j<board.getRow(); j++) {
				mat[i][j] =(ChessPeice) board.piece(i, j);		
			}
		}
		return mat;
	}
	
	private void nextTurn() {
		turn++;
		currentPlayer = (currentPlayer == Color.WHITE) ? Color.BLACK : Color.WHITE;
		
	}
	
	public boolean[][] possiblemoves(ChessPosition sourcePosition) {
		Position position = sourcePosition.toPosition();
		validateSourcePosition(position);
		return board.piece(position).possibleMoves();
	}
	
	public ChessPeice  perforChessMove(ChessPosition sourcePosition, ChessPosition targetPosition) {
		Position source = sourcePosition.toPosition();
		Position target = targetPosition.toPosition();
		validateSourcePosition(source);
		validateTargetPosition(source, target);
		Piece capturedPiece = makeMove(source, target);
		
		if (testCheck(currentPlayer)) {
			undoMove(source, target, capturedPiece);
		  throw new ChessExcepition("you can't put yourself in CHECK");
		
		}
		check = (testCheck(opponet(currentPlayer))) ? true : false;
		
		if (testCheckMate(opponet(currentPlayer))) {
			checkMate = true;
			
		}
		else {
		nextTurn();
		
	}
		return (ChessPeice)capturedPiece;	
	}
	
	
	private void validateTargetPosition(Position source, Position target) {
		if(!board.piece(source).possiblemoves(target)) {
			throw new ChessExcepition("The chose piece can't move to target position");
			
		}
		
	}

	private Piece makeMove(Position source, Position target) {
		Piece p = board.removePiece(source);
		Piece capturedPiece = board.removePiece(target);
		board.placePiece(p, target);
		
		if ( capturedPiece != null) {
			pieceOnTheBoard.remove(capturedPiece);
			this.capturedPiece.add(capturedPiece);
		}
		return capturedPiece;
		
		
	}
	
	private void undoMove(Position source, Position target, Piece capturedPiece) {
		Piece p = board.removePiece(target);
		board.placePiece(p, source);
		
		if(capturedPiece != null ) {
			board.placePiece(capturedPiece, target);
			this.capturedPiece.remove(capturedPiece);
			pieceOnTheBoard.add(capturedPiece);
			
		}
	}

	private void validateSourcePosition(Position position) {
	 if (!board.thereIsAPiece(position)) {
		 throw new ChessExcepition("there is not a piece on source position");
	 } if (currentPlayer != ((ChessPeice)board.piece(position)).getColor()) {
		 throw new ChessExcepition("there is not your piece");
		 
	 }
	 if (!board.piece(position).IsThereAnyPossibleMove()) {
		 throw  new ChessExcepition("there is not possible moves for the chosen piece");
		 
	 }
		
	}
	private Color opponet(Color color) {
		return (color == Color.WHITE) ? Color.BLACK : Color.WHITE; 
	}
	private ChessPeice king (Color color) {
		List<Piece> list = pieceOnTheBoard.stream().filter(x -> ((ChessPeice)x).getColor() == color).collect(Collectors.toList());
		for(Piece p: list) {
			if(p instanceof King) {
				return (ChessPeice) p;
			}
		}
		throw new IllegalStateException("There is no " + color + "King on the board"  );
		
	}

	private void  placeNewPice(char column, int row, ChessPeice piece) {
   board.placePiece(piece, new ChessPosition(column, row).toPosition());
    pieceOnTheBoard.add(piece);
   
	}
	
	private boolean testCheck(Color color) {
		Position kingPosition = king(color).getChessPosition().toPosition();
		List<Piece> opponentPieces = pieceOnTheBoard.stream().filter(x -> ((ChessPeice)x).getColor() == opponet(color)).collect(Collectors.toList());
		for (Piece p : opponentPieces) {
			boolean[][] mat = p.possibleMoves();
			if (mat[kingPosition.getRow()][kingPosition.getColumn()]) {
				return true;
			}
		}
		return false;
	}
	private boolean testCheckMate(Color color) {
		if (!testCheck(color)) {
			return false;
		}
		List<Piece> list = pieceOnTheBoard.stream().filter(x -> ((ChessPeice)x).getColor() == color).collect(Collectors.toList());
		for (Piece p : list) {
			boolean[][] mat = p.possibleMoves();
			for (int i=0; i<board.getRow(); i++) {
				for (int j=0; j<board.getColumn(); j++) {
					if (mat[i][j]) {
						Position source = ((ChessPeice)p).getChessPosition().toPosition();
						Position target = new Position(i, j);
						Piece capturedPiece = makeMove(source, target);
						boolean testCheck = testCheck(color);
						undoMove(source, target, capturedPiece);
						if (!testCheck) {
							return false;
						}
					}
				}
			}
		}
		return true;
	}	
	
	private void initialSetup() {
		placeNewPice('h', 7, new Rook(board, Color.WHITE));
        placeNewPice('d', 1, new Rook(board, Color.WHITE));
        placeNewPice('e', 1, new King(board, Color.WHITE));
        
        placeNewPice('b', 8, new Rook(board, Color.BLACK));
        placeNewPice('a', 8, new King(board, Color.BLACK));
		
		//board.placePiece(new Rook(board, Color.WHITE) , new Position(0, 6));
	}
 
}
