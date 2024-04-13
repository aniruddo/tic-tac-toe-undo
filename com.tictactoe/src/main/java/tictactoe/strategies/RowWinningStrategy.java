package tictactoe.strategies;

import java.util.HashMap;
import java.util.Map;

import tictactoe.models.Board;
import tictactoe.models.Move;
import tictactoe.models.Player;

public class RowWinningStrategy implements WinningStrategy {
	Map<Integer, Map<Character, Integer>> rowMaps = new HashMap<>();
	
	@Override
	public boolean checkWin(Board board, Move lastMove) {
		int row = lastMove.getCell().getRow();
		Player player = lastMove.getPlayer();

		if (!rowMaps.containsKey(row)) {
			rowMaps.put(row, new HashMap<>());
		}

		Map<Character, Integer> rowCountMap = rowMaps.get(row);
		if (!rowCountMap.containsKey(player.getSymbol())) {
			rowCountMap.put(player.getSymbol(), 0);
		}
		rowCountMap.put(player.getSymbol(), rowCountMap.get(player.getSymbol()) + 1);

		if (rowCountMap.get(player.getSymbol()).equals(board.getDimension())) {
			return true;
		}

		return false;
	}

}
