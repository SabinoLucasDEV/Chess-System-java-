package BoardGame;

public class Position {
	private int row;
	private int column;
	
	
	public Position(int row, int column) {
		super();
		this.row = row;
		this.column = column;
	}


	public int getRow() {
		return row;
	}




	public void setRow(int row) {
		this.row = row;
	}




	public int getColumn() {
		return column;
	}




	public void setColumn(int column) {
		this.column = column;
	}




	@Override
	public String toString() {
		return row + "," + column;
	}
	
	public void setValue(int row, int column) {
		this.row = row;
		this.column = column;
		
	}
	
	
	
	

}
