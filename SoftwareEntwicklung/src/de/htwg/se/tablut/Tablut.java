package de.htwg.se.tablut;
import de.htwg.se.tablut.aview.*;
import de.htwg.se.tablut.bcontroller.Controller;
import java.util.Scanner;

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
		Scanner sc = new Scanner(System.in);
		while (controller.winGameAttack() && controller.winGame()){
			textUI.funktion(sc.next());
		}
		System.out.println("Bla hat gewonnen");
	}
	
	public static void main(String[] args) {
		Tablut tablut = new Tablut();
	}

}
