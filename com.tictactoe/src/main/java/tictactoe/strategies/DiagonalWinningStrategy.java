package tictactoe.strategies;

import java.util.HashMap;
import java.util.Map;

import tictactoe.models.Board;
import tictactoe.models.Move;
import tictactoe.models.Player;

public class DiagonalWinningStrategy implements WinningStrategy {

	Map<Integer, Map<Character, Integer>> diaMap = new HashMap();

	@Override
	public boolean checkWin(Board board, Move lastMove) {
		int row = lastMove.getCell().getRow();
		int col = lastMove.getCell().getColumn();
		Player player = lastMove.getPlayer();
		int n = board.getDimension();
		if (row == col) {
			if (!diaMap.containsKey(0)) {
				diaMap.put(0, new HashMap<>());
			}
			Map<Character, Integer> FirstDiaCountMap = diaMap.get(0);

			if (!FirstDiaCountMap.containsKey(player.getSymbol())) {
				FirstDiaCountMap.put(player.getSymbol(), 0);
			}

			FirstDiaCountMap.put(player.getSymbol(), FirstDiaCountMap.get(player.getSymbol()) + 1);

			if (FirstDiaCountMap.get(player.getSymbol()).equals(board.getDimension())) {
				return true;
			}
		}
		if((n-1)-row==col || row-(n-1)==col) {
			if (!diaMap.containsKey(1)) {
				diaMap.put(1, new HashMap<>());
			}
			Map<Character, Integer> FirstDiaCountMap = diaMap.get(1);

			if (!FirstDiaCountMap.containsKey(player.getSymbol())) {
				FirstDiaCountMap.put(player.getSymbol(), 0);
			}

			FirstDiaCountMap.put(player.getSymbol(), FirstDiaCountMap.get(player.getSymbol()) + 1);

			if (FirstDiaCountMap.get(player.getSymbol()).equals(board.getDimension())) {
				return true;
			}
		}
		
		return false;
	}

//	@Override
//	public void handleUndo(Board board, Move lastMove) {
//
//	}
}