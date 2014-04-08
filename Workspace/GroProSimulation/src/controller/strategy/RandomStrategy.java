package controller.strategy;

import java.util.List;
import java.util.Random;

import model.GameState;

public class RandomStrategy extends AbstractStrategy
{
	@Override
	public GameState getNextGameState(GameState gameState) {
		super.getNextGameState(gameState);
		
		int counter = 0;
		int lastIndexWithNotZeroEntry = -1;
		List<Integer> columns = gameState.getColumns();
		GameState resultGameState = new GameState(gameState);
		
		for(int i = 0; i < columns.size(); ++i)
		{
			if(columns.get(i) != 0) {
				++counter;
				lastIndexWithNotZeroEntry = i;
			}
		}
		
		if(counter == 1)
		{
			// Die letzte Zeile wird sofort auf 0 gesetzt
			resultGameState.changeValueOfColumn(lastIndexWithNotZeroEntry, 0);
		}
		else
		{
			Random randomGenerator = new Random();
			int columnIndex = 0;
			
			do { // suche eine zufällige zeile != 0
				columnIndex = randomGenerator.nextInt(lastIndexWithNotZeroEntry+1);
			} while(columns.get(columnIndex) == 0); 
			
			int newValue = 1 + randomGenerator.nextInt(columns.get(columnIndex));
			
			resultGameState.changeValueOfColumn(columnIndex, columns.get(columnIndex) - newValue); // setze einen zufälligen wert
		}
		
		return resultGameState;
	}

}
