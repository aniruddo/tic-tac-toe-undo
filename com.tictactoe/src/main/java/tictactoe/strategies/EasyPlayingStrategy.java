package tictactoe.strategies;

import tictactoe.models.Board;
import tictactoe.models.Cell;
import tictactoe.models.CellState;
import tictactoe.models.Player;

public class EasyPlayingStrategy implements BotPlayingStrategy {
    @Override
    public Cell makeMove(Board board, Player player) {
        for(int i=0;i<board.getDimension();i++){
            for(int j=0;j<board.getDimension();j++){
                Cell cell = board.getBoard().get(i).get(j);
                if(cell.getCellState() == CellState.EMPTY){
                    cell.setCellState(CellState.FILLED);
                    cell.setPlayer(player);
                    return cell;
                }
            }
        }
        return null;
    }
}
