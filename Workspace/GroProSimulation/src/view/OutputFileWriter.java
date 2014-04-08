package view;

import java.io.File;
import java.util.List;

import model.GameState;
import model.PlayerStatistics;

public class OutputFileWriter extends OutputWriter {
	private File file;
	
	public OutputFileWriter(String path) {
		this.file = new File(path);
	}
	
	public OutputFileWriter(File file) {
		this.file = file;
	}
	
	@Override
	public void write(String comment, PlayerStatistics player1Statistics,
			PlayerStatistics player2Statistics)
	{
		int numberOfAllGames = player1Statistics.wonGames + player2Statistics.wonGames;
		List<GameState> anyGame = (player1Statistics.wonGame != null ? player1Statistics.wonGame : player2Statistics.wonGame);
		long percentage1 = Math.round((player1Statistics.wonGames * 100.0) / numberOfAllGames);
		long percentage2 = Math.round((player2Statistics.wonGames * 100.0) / numberOfAllGames);
		
		// TODO implement writing to file
		System.out.print(comment);
		System.out.println("Startverteilung: " + anyGame.get(0));
		System.out.println("Gewonnene Spiele Spieler 1: " + percentage1 + " %");
		System.out.println("Gewonnene Spiele Spieler 2: " + percentage2 +  " %");
		
		writeExample(1, player1Statistics.wonGame);
		writeExample(2, player2Statistics.wonGame);
		
	}
	
	private void writeExample(int playerNumber, List<GameState> game) {
		System.out.println("Beispiel eines von Spieler " + playerNumber + " gewonnenen Spiels:");
		
		if(game != null) {
			String firstState, secondState;
			
			for(int count = 1; count < game.size(); ++count)
			{
				firstState = game.get(count-1).toString();
				secondState = game.get(count).toString();
				playerNumber = (1 + ((count-1) % 2));
				System.out.println("Zug " + count + ", Spieler " + playerNumber + " : " + firstState + " -> " + secondState);
			}
		} else {
			System.out.println("Nicht vorhanden.");
		}
	}

}
