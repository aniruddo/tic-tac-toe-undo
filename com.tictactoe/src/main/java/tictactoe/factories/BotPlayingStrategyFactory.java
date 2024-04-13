package tictactoe.factories;

import tictactoe.models.BotDifficultyLevel;
import tictactoe.strategies.BotPlayingStrategy;
import tictactoe.strategies.EasyPlayingStrategy;

public class BotPlayingStrategyFactory {
	public static BotPlayingStrategy getBotPlayingStrategy(BotDifficultyLevel difficultyLevel){
//      if(difficultyLevel == BotDifficultyLevel.EASY)
      return new EasyPlayingStrategy();
  }
}
