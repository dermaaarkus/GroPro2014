package view;

import model.PlayerStatistics;

public abstract class OutputWriter {
	public abstract void write(String comment, PlayerStatistics player1Statistics, PlayerStatistics player2Statistics);
}
