package model;

import java.util.List;

import controller.strategy.AbstractStrategy;

public class Player {
	private PlayerStatistics statistics;
	private AbstractStrategy strategy;
	
	public Player(AbstractStrategy strategy) {
		this.statistics = new PlayerStatistics();
		this.strategy = strategy; 
	}

	public PlayerStatistics getStatistics() {
		return statistics;
	}

	public void setStrategy(AbstractStrategy strategy) {
		this.strategy = strategy;
	}

	public void didWinGame(List<GameState> game) {
		statistics.wonGame = game;
		++statistics.wonGames;
	}
	
	/**
	 * Ruft getNextGameState(GameState gameState) auf der Strategie auf.
	 * 
	 * @param gameState Der aktuelle Spielstatus
	 * @return Der Spielstatus nach dem Zug des Spielers
	 */
	public GameState getNextGameState(GameState gameState) {
		return strategy.getNextGameState(gameState);
	}
}
