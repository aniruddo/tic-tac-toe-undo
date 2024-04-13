package tictactoe.strategies;

import tictactoe.models.Board;
import tictactoe.models.Player;
import tictactoe.models.Cell;

public interface BotPlayingStrategy {
	public Cell makeMove(Board board, Player player);
}
