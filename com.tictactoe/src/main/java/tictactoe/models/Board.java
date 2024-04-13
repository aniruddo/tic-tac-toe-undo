package tictactoe.models;

import java.util.ArrayList;
import java.util.List;

public class Board {
	private Integer dimension;

	private List<List<Cell>> board;

	public Board(Integer dimension) {
		this.dimension = dimension;
		this.board = new ArrayList<>();

		for (int i = 0; i < dimension; i++) {
			board.add(new ArrayList<>());

			for (int j = 0; j < dimension; j++) {
				board.get(i).add(new Cell(i, j));
			}
		}
	}

	public Integer getDimension() {
		return dimension;
	}

	public void setDimension(Integer dimension) {
		this.dimension = dimension;
	}

	public List<List<Cell>> getBoard() {
		return board;
	}

	public void setBoard(List<List<Cell>> board) {
		this.board = board;
	}

	public void display() {
		// TODO Auto-generated method stub
		System.out.println("Current board :");
        for(int i=0;i<dimension;i++){
            for(int j=0;j<dimension;j++){
                board.get(i).get(j).display();
            }
            System.out.println();
        }
	}

}
