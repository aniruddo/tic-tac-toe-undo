package tictactoe.models;

import tictactoe.exceptions.BotCountExceedsLimitException;
import tictactoe.exceptions.DuplicateSymbolException;
import tictactoe.exceptions.PlayersCountDimensionMismatchException;
import tictactoe.strategies.*;
import tictactoe.validations.GameValidations;

import java.util.ArrayList;
import java.util.List;

public class Game {
	 private Board board;
	    private List<Player> players;
	    private List<Move> moves;
	    private GameState gameState;
	    private Player winner;
	    private Integer nextPlayerIndex;
	    private List<WinningStrategy> winningStrategyList;


	    private Game(Integer dimension, List<Player> players, List<WinningStrategy> winningStrategyList) {
	        this.players = players;
	        this.winningStrategyList = winningStrategyList;
	        this.board = new Board(dimension);
	        this.gameState = GameState.IN_PROGRESS;
	        this.nextPlayerIndex = 0;
	        this.moves = new ArrayList<>();
	    }

	    public void printBoard(){
	        board.display();
	    }

	    public void makeMove(){
	        Player player = players.get(nextPlayerIndex);
	        Cell cell = player.makeMove(this.board);

	        Move move = new Move(player, cell);
	        this.moves.add(move);

	        if(checkWinner(this.board, move)){
	            this.gameState = GameState.CONCLUDED;
	            this.winner = player;
	            return;
	        }

	        if(this.moves.size() == this.board.getDimension()* this.board.getDimension()){
	            this.gameState = GameState.DRAW;
	            return;
	        }



	        nextPlayerIndex++;
	        nextPlayerIndex %= players.size();
	    }

	    public void undo(){
	        if(this.moves.size() <= 0){
	            System.out.println("No valid moves to undo");
	            return;
	        }

	        Move lastMove = this.moves.get(this.moves.size()-1);
	        this.moves.remove(lastMove);

	        Cell cell = lastMove.getCell();
	        cell.setPlayer(null);
	        cell.setCellState(CellState.EMPTY);

	        for(WinningStrategy ws: this.winningStrategyList){
	            ws.handleUndo(board, lastMove);
	        }

	        if(nextPlayerIndex > 0){
	            nextPlayerIndex--;
	        }else{
	            nextPlayerIndex = players.size()-1;
	        }

	    }
	    private boolean checkWinner(Board board, Move move){
	        for(WinningStrategy ws: this.winningStrategyList){
	            if(ws.checkWin(board, move)){
	                return true;
	            }
	        }

	        return false;
	    }

	    public List<Move> getMoves() {
	        return moves;
	    }

	    public GameState getGameState() {
	        return gameState;
	    }

	    public Player getWinner() {
	        return winner;
	    }

	    public static Builder getBuilder(){
	        return new Builder();
	    }

	    public  static class Builder {
	        Integer dimension;
	        List<Player> players;
	        List<WinningStrategy> winningStrategyList;


	        public Builder setDimension(Integer dimension) {
	            this.dimension = dimension;
	            return this;
	        }

	        public Builder setPlayers(List<Player> players) {
	            this.players = players;
	            return this;
	        }

	        public Builder setWinningStrategyList(List<WinningStrategy> winningStrategyList) {
	            this.winningStrategyList = winningStrategyList;
	            return this;
	        }

	        public Game build() throws BotCountExceedsLimitException, DuplicateSymbolException, PlayersCountDimensionMismatchException {
	            //validations
	            GameValidations.validatePlayerCountAndBoardDimension(this.players, dimension);
	            GameValidations.validateUniqueSymbolsForPlayers(this.players);
	            GameValidations.validateBotCount(this.players, 1);
	            return new Game(this.dimension, this.players, this.winningStrategyList);
	        }
	    }
	
}
