package main;

import java.io.File;
import java.io.FileNotFoundException;

import controller.Controller;

public class NimGame {
	public static void main(String[] args) {
		String in = "resources/input/ihk_example.in";
		String out = "resources/output/ihk_example.out";
		
		try {
			Controller c = new Controller(new File(in), new File(out));
			c.playGames(10);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
	}
}
