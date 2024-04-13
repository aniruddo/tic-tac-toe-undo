package tictactoe.strategies;

import tictactoe.models.Board;
import tictactoe.models.Move;

public interface WinningStrategy {
	 public boolean checkWin(Board board, Move lastMove);

	public void handleUndo(Board board, Move lastMove);
	 
}
