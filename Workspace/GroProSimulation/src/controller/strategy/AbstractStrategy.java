package controller.strategy;

import model.GameState;

public abstract class AbstractStrategy {
	/**
	 * Bestimmt den n�chsten Spielzug der Strategie.
	 * 
	 * @param gameState Der aktuelle Spielstatus
	 * @return Den n�chsten Spielstatus
	 * @throws InvalidArgumentException Falls der �bergebene Spielstatus bereits das Ende eines Spiels repr�sentiert
	 */
	public GameState getNextGameState(GameState gameState) {
		if(gameState.isFinishState()) {
			throw new IllegalArgumentException("Es kann kein weiterer Spielzug durchgef�hrt werden.");
		}
		
		return null;
	}
}
