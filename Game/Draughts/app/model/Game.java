package model;

public class Game {
	private static int GAME_ID = 1;

	private int id;
	private Board board;
	private Player currentPlayer;
	private Player opponent;

	public Game() {
		this.id = GAME_ID++;	
	}
	
	public void initBoard(){
		this.board = new Board();
	}

	public int getId() {
		return this.id;
	}

	public Board getBoard() {
		return board;
	}

	public void setBoard(Board board) {
		this.board = board;
	}

	public Player getCurrentPlayer() {
		return currentPlayer;
	}

	public void setCurrentPlayer(Player currPlayer) {
		this.currentPlayer = currPlayer;
	}

	public Player getOpponent() {
		return opponent;
	}

	public void setOpponent(Player opponent) {
		this.opponent = opponent;
	}

	public void switchPlayer() {
		 Player temp = getCurrentPlayer();
		 setCurrentPlayer(getOpponent());
		 setOpponent(temp);
	}
}