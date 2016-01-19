package de.htwg.se.tablut;
import de.htwg.se.tablut.aview.*;
import de.htwg.se.tablut.bcontroller.Controller;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Tablut {
	
	private static final Logger LOGGER= Logger.getLogger(Tablut.class.getName());
	private TextUI textUI;
	private Gui gui;
	private Controller controller;
	
	public Tablut(){
		controller = new Controller();
		gui = new Gui(controller);
		textUI = new TextUI(controller);
		Scanner sc = new Scanner(System.in);
		LOGGER.setLevel(Level.FINEST);
		LOGGER.info("Geben Sie eine Feldgroesse an.");
		do{
			textUI.funktion(sc.next());
		}while (controller.winGameAttack() && controller.winGame());
	}
	
	public static void main(String[] args) {
		Tablut tablut = new Tablut();
	}

}
