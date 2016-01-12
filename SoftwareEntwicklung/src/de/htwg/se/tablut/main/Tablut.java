package de.htwg.se.tablut.main;
import de.htwg.se.tablut.aview.*;
import de.htwg.se.tablut.bcontroller.Controller;

public class Tablut {
	private TextUI textUI;
	private Gui gui;
	private Controller controller;
	
	public Tablut(){
		controller = new Controller();
		gui = new Gui(controller);
		textUI = new TextUI(controller);
		controller.getGamefield().setStart(controller.sizeOfMatrix());
		controller.notifyObservers();
		while (true){
			controller.funktion();
		}
	}
	
	public static void main(String[] args) {
		Tablut tablut = new Tablut();
	}

}
