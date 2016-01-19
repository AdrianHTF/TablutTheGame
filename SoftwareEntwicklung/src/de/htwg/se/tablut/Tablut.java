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
		Scanner sc = new Scanner(System.in);
		System.out.println("Geben Sie eine Feldgroesse an.");
		do{
			textUI.funktion(sc.next());
		}while (controller.winGameAttack() && controller.winGame());
		System.out.println("Bla hat gewonnen");
	}
	
	public static void main(String[] args) {
		Tablut tablut = new Tablut();
	}

}
