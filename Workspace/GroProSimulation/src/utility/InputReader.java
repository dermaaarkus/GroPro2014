package utility;

import java.io.FileNotFoundException;

import model.GameState;

public abstract class InputReader {
	public abstract String getComment() throws FileNotFoundException;
	public abstract GameState getFirstGameState()  throws FileNotFoundException;
}
