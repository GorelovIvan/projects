package controllers;

import play.libs.Json;
import play.mvc.Controller;
import play.mvc.Result;
import engine.PlayGame;

public class GameController extends Controller {

	public static Result index(){
		return ok();
	}
	
	public static Result addPlayer(String name) {
		return ok(Json.toJson(PlayGame.addPlayer(name)));
	}

	public static Result getBoard(int gameId) {
		return ok(Json.toJson(PlayGame.getBoard(gameId)));
	}

	public static Result move(int gameId, String name, int fromX, int fromY, int toX, int toY) {
		return ok(Json.toJson(PlayGame.move(gameId, name, fromX, fromY, toX, toY)));
	}
}