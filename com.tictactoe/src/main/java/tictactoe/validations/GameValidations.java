package tictactoe.validations;

import java.util.HashSet;
import java.util.List;

import tictactoe.exceptions.BotCountExceedsLimitException;
import tictactoe.exceptions.DuplicateSymbolException;
import tictactoe.exceptions.PlayersCountDimensionMismatchException;
import tictactoe.models.Player;
import tictactoe.models.PlayerType;

public class GameValidations {
	public static boolean validatePlayerCountAndBoardDimension(List<Player> players, Integer dimension) throws PlayersCountDimensionMismatchException {
        if(players.size() >= dimension){
            throw new PlayersCountDimensionMismatchException();
        }
        return true;
    }

    public static boolean validateUniqueSymbolsForPlayers(List<Player> players) throws DuplicateSymbolException {
        HashSet<Character> symbolSet = new HashSet();

        for(Player player: players){
            if(symbolSet.contains(player.getSymbol())){
                throw new DuplicateSymbolException();
            }
            symbolSet.add(player.getSymbol());
        }
        return true;
    }

    public static boolean validateBotCount(List<Player> players, Integer count) throws BotCountExceedsLimitException {
        int botCount = 0;
        for(Player player: players){
            if(player.getPlayerType().equals(PlayerType.BOT)){
                botCount++;
            }

            if(botCount > count){
                throw new BotCountExceedsLimitException();
            }
        }
        return true;
    }
}
