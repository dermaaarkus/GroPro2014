package controller.strategy;

import model.GameState;

public class Possibility {
	public GameState gameState;
	public int rating;
	
	public Possibility(GameState gameState) {
		this.gameState = gameState;
	}
}
