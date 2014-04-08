package utility;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

import model.GameState;

public class InputFileReader extends InputReader {

	private File file;
	
	public InputFileReader(String path) {
		file = new File(path);
	}
	
	public InputFileReader(File file) {
		this.file = file;
	}
	
	@Override
	public String getComment() throws FileNotFoundException {
		Scanner sc = new Scanner(file);
		String line;
		StringBuilder allComments = new StringBuilder();
		
		while(sc.hasNextLine())
		{
			line = sc.nextLine();
			if(line.length() > 0 && line.charAt(0) == '#') {
				// fuege zeile zu kommentar hinzu
				allComments.append(line + "\n");
			} else {
				// stoppe, da keine weiteren zeilen folgen k�nnen
				break;
			}
		}
		
		sc.close();
		
		if(allComments.length() == 0) { // ist leer?
			throw new InputMismatchException("Kein Kommentar gefunden!");
		} else {
			return allComments.toString();			
		}
	}

	@Override
	public GameState getFirstGameState()  throws FileNotFoundException {
		Scanner sc = new Scanner(file);
		String line = null;
		
		while(sc.hasNextLine())
		{
			line = sc.nextLine();
			if(line.length() > 0 && line.charAt(0) != '#') {
				// stoppe, da nun die erste zeile mit daten gefunden worden ist
				break;
			}
		}
		
		sc.close();
		
		if(line != null)
		{
			return parseGameStateFromLine(line.trim());
		} else {
			throw new InputMismatchException("Keine Daten gefunden!");
		}

	}

	/**
	 * Parsed die Daten f�r einen Spielstatus.
	 * 
	 * @param line Die Daten als String mit Leerzeichen zwischen den Integern
	 * @return Den erzeugten Spielstatus
	 * @throws InputMismatchException Falls zu viele Reihen gefunden wurden
	 * @throws NumberFormatException Falls die Werte nicht geparsed werden konnten
	 */
	private GameState parseGameStateFromLine(String line) {
		String[] parts = line.split(" ");
		List<Integer> resultList = new ArrayList<>();
		
		// TODO: as constant
		if(parts.length >= 1 && parts.length <= 9)
		{
			for(String p : parts)
			{
				// TODO: test if valid integer
				resultList.add(Integer.parseInt(p));
			}
		}
		else {
			throw new InputMismatchException("Zu viele Reihen gefunden!");
		}
		
		return new GameState(resultList);
	}
}