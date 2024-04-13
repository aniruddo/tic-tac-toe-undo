package tictactoe.models;

import tictactoe.factories.BotPlayingStrategyFactory;
import tictactoe.strategies.BotPlayingStrategy;

public class BotPlayer extends Player {
	
	public BotPlayer(String name, Integer gamerID, Character symbol, PlayerType playerType, BotDifficultyLevel botDifficultyLevel) {
        super(name, gamerID, symbol, playerType);
        this.botDifficultyLevel = botDifficultyLevel;
        this.botPlayingStrategy = BotPlayingStrategyFactory
                .getBotPlayingStrategy(this.botDifficultyLevel);
    }
	
	private BotDifficultyLevel botDifficultyLevel;
	private BotPlayingStrategy botPlayingStrategy;
	public BotDifficultyLevel getBotDifficultyLevel() {
		return botDifficultyLevel;
	}
	public void setBotDifficultyLevel(BotDifficultyLevel botDifficultyLevel) {
		this.botDifficultyLevel = botDifficultyLevel;
	}
	 public Cell makeMove(Board board) {
	        System.out.println("Bot player is making a move.");
	        return botPlayingStrategy.makeMove(board, this);
	    }
}
