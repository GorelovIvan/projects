package engine;

import java.util.HashMap;

import model.Board;
import model.Game;
import model.Player;
import model.PlayerColor;

public class PlayGame {
	private static Game game = null;
	private static HashMap<Integer, Game> games = new HashMap<Integer, Game>();

	public static Player addPlayer(String name) {
		Player p = new Player();
		if (game == null) {
			game = new Game();
			game.initBoard();
		}

		p.setGameId(game.getId());
		p.setName(name);

		if (game.getCurrentPlayer() == null) {
			p.setPlayerColor(PlayerColor.white);
			game.setCurrentPlayer(p);
		} else {
			p.setPlayerColor(PlayerColor.black);
			game.setOpponent(p);
			games.put(game.getId(), game);
			game = null;
		}

		return p;
	}
	
	public static Board getBoard(int gameId){
		return games.get(gameId).getBoard();
	}

	public static boolean move(int gameId, String name, int fromX, int fromY, int toX,
			int toY) {

		Game curGame = games.get(gameId);

		if (curGame.getCurrentPlayer().getName().equals(name)) {
			if(curGame.getBoard().move(curGame.getCurrentPlayer().getPlayerColor(), fromX, fromY, toX, toY)){
				curGame.switchPlayer();
				return true;
			}
		}
		return false;
	}

}
