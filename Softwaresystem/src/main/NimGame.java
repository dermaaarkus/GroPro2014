package main;

import java.io.File;
import java.util.InputMismatchException;

import controller.Controller;

public class NimGame {
	/**
	 * Die Anzahl an durchzuführenden Spielen.
	 */
	public static int NUMBER_OF_GAMES = 10;
	
	/**
	 * Führt eine Anzahl von Nimspielen durch. 
	 * @param args 0: Die Eingabedatei 1: Die Ausgabedatei
	 */
	public static void main(String[] args) {
		if(args.length >= 2) { 
			String in = args[0];
			String out = args[1];
			
			try {
				Controller c = new Controller(new File(in), new File(out));
				c.playGames(NUMBER_OF_GAMES);
			} catch(InputMismatchException ime) {
				// ignore, because the error has already been written to the view
			} catch (Exception e) {
				System.err.println("Exception: " + e.getLocalizedMessage());
			}
		} else {
			// brich ab, da keine parameter übergeben wurden
			System.err.println("Das Programm benötigt mindestens zwei Übergabeparameter:\n"
					+ "1.) Der Name der Eingabedatei\n"
					+ "2.) Der Name der Ausgabedatei");
		}
	}
}
