package BoardGame;

public class Board {

	private int row;
	private int column;
	private Piece[][] piece;
	
		
	public Board(int row, int column) {
		this.row = row;
		this.column = column;
		piece = new Piece[row][column];
		
		
	}
	
	
	
}
