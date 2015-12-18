package de.htwg.se.tablut.main;
import de.htwg.se.tablut.aview.*;
import de.htwg.se.tablut.bcontroller.Controller;

public class Tablut {
	private TextUI textUI;
	private Controller controller;
	
	public Tablut(){
		controller = new Controller();
		textUI = new TextUI(controller);
	}
	
	public static void main(String[] args) {
		Tablut tablut = new Tablut();
	}

}
