package BoardGame;

public class Board {

	private int rows;
	private int columns;
	private Piece[][] pieces;
	
		
	public Board(int row, int column) {
		if (row < 1 || column < 1  ) {
			throw new BoardException("Erro ao criar o tabuleiro: deve ter pelomenos 1 linha ou 1 coluna");
		}
 		this.rows = row;
		this.columns = column;
		pieces = new Piece[row][column];
	}

	public int getRow() {
		return rows;
	}

	public int getColumn() {
		return columns;
	}
	
	public Piece piece (int row, int column) {
		if (! positionExist(row, column)) {
			throw new BoardException("Não existe essa posição no tabuleiro");
		}
		return pieces[row][column];
	}
	public Piece piece(Position position) {
		if (!positionExist(position)) {
			throw new BoardException("Não existe essa posição no tabuleiro");
		}
		return pieces[position.getRow()] [position.getColumn()];
	}
	
	public void placePiece(Piece piece, Position position) {
		if (thereIsAPiece(position)) {
			throw new BoardException("Ja possui um peça nessa posição" + position);
		}
		
		pieces[position.getRow()][position.getColumn()] = piece;
		piece.position = position;
		
	}
	
	public boolean positionExist(int row, int column) {
		return row >=0 && row < rows  && column >= 0 &&  column < columns;
	}
	
	public boolean positionExist(Position position)  {
		return positionExist(position.getRow(), position.getColumn());
		 
	}
	
	public boolean thereIsAPiece(Position position) {
		if (!positionExist(position)) {
			throw new BoardException("Não existe essa posição no tabuleiro");
		}
		return piece(position) !=null;
	}
}
