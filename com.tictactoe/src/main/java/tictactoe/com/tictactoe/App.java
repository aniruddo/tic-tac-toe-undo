package tictactoe.com.tictactoe;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import tictactoe.controllers.GameController;
import tictactoe.exceptions.BotCountExceedsLimitException;
import tictactoe.exceptions.DuplicateSymbolException;
import tictactoe.exceptions.PlayersCountDimensionMismatchException;
import tictactoe.models.BotDifficultyLevel;
import tictactoe.models.BotPlayer;
import tictactoe.models.Game;
import tictactoe.models.GameState;
import tictactoe.models.HumanPlayer;
import tictactoe.models.Player;
import tictactoe.models.PlayerType;
import tictactoe.strategies.ColWinningStretegy;
import tictactoe.strategies.DiagonalWinningStrategy;
import tictactoe.strategies.RowWinningStrategy;
import tictactoe.strategies.WinningStrategy;

/**
 * Hello world!
 *
 */
public class App 
{
	public static void main(String[] args) throws PlayersCountDimensionMismatchException, BotCountExceedsLimitException, DuplicateSymbolException {
        GameController gameController = new GameController();
        Scanner scanner = new Scanner(System.in);
        Player playerA = new HumanPlayer("Aniruddh", 1, 'X', PlayerType.HUMAN);
        Player playerB = new BotPlayer("BotPlayer", 2, 'O', PlayerType.BOT, BotDifficultyLevel.EASY);
        List<Player> players = new ArrayList();
        players.add(playerA);
        players.add(playerB);

        WinningStrategy rowWinning = new RowWinningStrategy();
        WinningStrategy colWinning = new ColWinningStretegy();
        WinningStrategy diaWinning = new DiagonalWinningStrategy();
        List<WinningStrategy> strategies = new ArrayList<>();
        strategies.add(rowWinning);
        strategies.add(colWinning);
        strategies.add(diaWinning);

        Game game = gameController.startGame(3, players, strategies);
        while(game.getGameState().equals(GameState.IN_PROGRESS)){
            game.printBoard();

            System.out.println("Do you want to undo?(y/n)");
            String undo = scanner.next();

            if(undo.equalsIgnoreCase("y")){
                game.undo();
                continue;
            }

            game.makeMove();
        }
        game.printBoard();
        if(game.getGameState().equals(GameState.CONCLUDED)){
            System.out.println(game.getWinner().getName() + " have won");
        }

        if(game.getGameState().equals(GameState.DRAW)){
            System.out.println("It's a draw");
        }
    }
}
