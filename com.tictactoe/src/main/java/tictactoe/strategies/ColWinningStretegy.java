package tictactoe.strategies;

import java.util.HashMap;
import java.util.Map;

import tictactoe.models.Board;
import tictactoe.models.Move;
import tictactoe.models.Player;

public class ColWinningStretegy implements WinningStrategy {
	Map<Integer, Map<Character, Integer>> colMaps = new HashMap<>();

	@Override
	public boolean checkWin(Board board, Move lastMove) {
		 int col = lastMove.getCell().getColumn();
	        Player player = lastMove.getPlayer();

	        if(!colMaps.containsKey(col)){
	            colMaps.put(col, new HashMap<>());
	        }

	        Map<Character, Integer> colCountMap = colMaps.get(col);
	        if(!colCountMap.containsKey(player.getSymbol())){
	            colCountMap.put(player.getSymbol(), 0);
	        }
	        colCountMap.put(player.getSymbol(), colCountMap.get(player.getSymbol()) + 1);

	        if(colCountMap.get(player.getSymbol()).equals(board.getDimension())){
	            return true;
	        }

	        return false;
	}

//	@Override
//	public void handleUndo(Board board, Move lastMove) {
//		// TODO Auto-generated method stub
//		
//	}

}
