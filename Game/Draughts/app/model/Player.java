package model;

public class Player {
	
	private int gameId ;
	private String name ;
	private PlayerColor playerColor;
	
	public int getGameId() {
		return this.gameId;
	}
	public void setGameId(int gameId) {
		this.gameId = gameId;
	}
	public String getName() {
		return this.name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public PlayerColor getPlayerColor() {
		return this.playerColor;
	}
	public void setPlayerColor(PlayerColor playerColor) {
		this.playerColor = playerColor;
	}
	
}