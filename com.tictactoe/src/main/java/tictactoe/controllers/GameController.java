package tictactoe.controllers;

import java.util.List;

import tictactoe.exceptions.BotCountExceedsLimitException;
import tictactoe.exceptions.DuplicateSymbolException;
import tictactoe.exceptions.PlayersCountDimensionMismatchException;
import tictactoe.models.Game;
import tictactoe.models.Player;
import tictactoe.strategies.WinningStrategy;

public class GameController {
	public Game startGame(Integer dimension, List<Player> players, List<WinningStrategy> winningStrategyList) throws PlayersCountDimensionMismatchException, BotCountExceedsLimitException, DuplicateSymbolException {
        System.out.println("The game of TicTacToe begins!");
            return Game.getBuilder()
                    .setDimension(dimension)
                    .setPlayers(players)
                    .setWinningStrategyList(winningStrategyList)
                    .build();

    }

    public void makeMove(Game game){
        game.makeMove();
    }

    public void printBoard(Game game){
        game.printBoard();
    }

    public void undo(Game game){
//        game.undo();
    }
}
