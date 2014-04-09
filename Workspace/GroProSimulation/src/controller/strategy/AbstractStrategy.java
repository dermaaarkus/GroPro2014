package controller.strategy;

import model.GameState;

public abstract class AbstractStrategy {
	/**
	 * Bestimmt den nächsten Spielzug der Strategie.
	 * 
	 * @param gameState Der aktuelle Spielstatus
	 * @return Den nächsten Spielstatus
	 * @throws InvalidArgumentException Falls der übergebene Spielstatus bereits das Ende eines Spiels repräsentiert
	 */
	public GameState getNextGameState(GameState gameState) {
		if(gameState.isFinishState()) {
			throw new IllegalArgumentException("Es kann kein weiterer Spielzug durchgeführt werden.");
		}
		
		return null;
	}
}
