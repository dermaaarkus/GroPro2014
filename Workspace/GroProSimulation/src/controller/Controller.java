package controller;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;

import controller.strategy.*;
import utility.InputFileReader;
import view.OutputFileWriter;
import model.*;

public class Controller {
	private AbstractModel model;
	private OutputFileWriter view;
	
	public Controller(File inputFile, File outputFile) throws FileNotFoundException {
		Player player1 = new Player(new MyStrategy());
		Player player2 = new Player(new RandomStrategy());
		InputFileReader inputFileReader = new InputFileReader(inputFile);
		
		model = new Model(player1, player2, inputFileReader.getComment(), inputFileReader.getFirstGameState());
		view = new OutputFileWriter(outputFile);
	}
	
	public void playGames(int numberOfGames)
	{
		List<GameState> game;
		Player winningPlayer;
		
		for(int gameCounter = 0; gameCounter < numberOfGames; ++gameCounter)
		{
			game = playGame();
			
			if(game.size() % 2 == 0) // l�nge der liste gerade?
			{
				winningPlayer = model.getPlayer1();
			} else {
				winningPlayer = model.getPlayer2();
			}
			
			winningPlayer.didWinGame(game);
		}
		
		// write to view
		view.write(model.getComment(), model.getPlayer1().getStatistics(), model.getPlayer2().getStatistics());
	}
	
	public List<GameState> playGame() {
		Player player1 = model.getPlayer1();
		Player player2 = model.getPlayer2();
		
		int counter = 1;
		GameState state = model.getFirstGameState();
		List<GameState> game = new ArrayList<GameState>();
		game.add(state); // fuege start status hinzu
		
		
		while(state.isFinishState() == false) {
			if(counter % 2 == 1) // ist counter ungerade?
			{
				state = player1.getNextGameState(state);
			} else {
				state = player2.getNextGameState(state);
			}
			game.add(state); // fuege state zur liste hinzu
			++counter;
		}
		
		return game;
	}
}