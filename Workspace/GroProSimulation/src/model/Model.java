package model;

public class Model extends AbstractModel {

	private Player player1;
	private Player player2;
	private String comment;
	private GameState firstGameState;
	
	public Model(Player player1, Player player2, String comment, GameState firstGameState) {
		this.player1 = player1;
		this.player2 = player2;
		this.comment = comment;
		this.firstGameState = firstGameState;
	}
	
	@Override
	public Player getPlayer1() {
		return player1;
	}

	@Override
	public Player getPlayer2() {
		return player2;
	}

	@Override
	public String getComment() {
		return comment;
	}

	@Override
	public GameState getFirstGameState() {
		return firstGameState;
	}

}
