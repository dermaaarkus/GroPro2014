package model;

import java.util.List;

import controller.strategy.AbstractStrategy;

public class Player {
	/**
	 * Die Statistik des Spielers.
	 */
	private PlayerStatistics statistics;
	/**
	 * Die Strategie des Spielers.
	 */
	private AbstractStrategy strategy;
	
	/**
	 * Konstruktor.
	 * 
	 * @param strategy Übergibt dem Spieler eine Strategie, die er anwendet.
	 */
	public Player(AbstractStrategy strategy) {
		this.statistics = new PlayerStatistics();
		this.strategy = strategy; 
	}

	/**
	 * Gibt die Spieler-Statistik. 
	 * @return Die Statistik
	 */
	public PlayerStatistics getStatistics() {
		return statistics;
	}

	/**
	 * Setzt eine neue bzw. ändert die Strategie des Spielers.
	 * 
	 * @param strategy Die neue Strategie
	 */
	public void setStrategy(AbstractStrategy strategy) {
		this.strategy = strategy;
	}

	/**
	 * Speichert das gewonne Spiel in der Spielerstatistik.
	 * 
	 * @param game Das gewonnene Spiel
	 */
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
