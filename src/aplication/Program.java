package aplication;

import BoardGame.Board;
import BoardGame.Position;

public class Program {

	public static void main(String[] args) {
		Position pos = new Position(0, 0);
		
		System.out.println(pos);

		Board board = new Board(8, 8);
	}

}
