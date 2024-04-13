package tictactoe.models;

public abstract class Player {
	private String name;
	private Integer gamerID;
	private Character symbol;
	private PlayerType playerType;
	
	

	public Player(String name, Integer gamerID, Character symbol, PlayerType playerType) {
		super();
		this.name = name;
		this.gamerID = gamerID;
		this.symbol = symbol;
		this.playerType = playerType;
	}

	public abstract Cell makeMove(Board board);

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Integer getGamerID() {
		return gamerID;
	}

	public void setGamerID(Integer gamerID) {
		this.gamerID = gamerID;
	}

	public Character getSymbol() {
		return symbol;
	}

	public void setSymbol(Character symbol) {
		this.symbol = symbol;
	}

	public PlayerType getPlayerType() {
		return playerType;
	}

	public void setPlayerType(PlayerType playerType) {
		this.playerType = playerType;
	}
	
	
}
