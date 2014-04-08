package model;

import java.util.List;

public class PlayerStatistics {
	public int wonGames;
	public List<GameState> wonGame;
	
	public PlayerStatistics()
	{
		wonGames = 0;
		wonGame = null;
	}
}
