package model;

public abstract class AbstractModel {
	public abstract Player getPlayer1();
	public abstract Player getPlayer2();
	public abstract String getComment();
	public abstract GameState getFirstGameState();
}
