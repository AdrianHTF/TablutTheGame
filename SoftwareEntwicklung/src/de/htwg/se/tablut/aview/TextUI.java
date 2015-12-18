package de.htwg.se.tablut.aview;
import java.util.Scanner;
import de.htwg.se.tablut.bcontroller.*;
import de.htwg.se.tablut.util.*;

public class TextUI implements IObserver {
	private Controller controller;
	
	public TextUI(Controller c){
		this.controller = c;
		controller.addObserver(this);
		funktion();
		
	}
	
	public void funktion(){
		controller.notifyObservers();
		int xStart = 0;
		int yStart = 0;
		int xZiel = 0;
		int yZiel = 0;
		while(controller.winGame() && controller.winGameAttack()){
			System.out.println("\n\nBitte geben sie ihren Spielzug an:\n");
			Scanner sc = new Scanner(System.in);
				
				if(sc.hasNextInt())
					xStart = sc.nextInt();	// Eingabe X-Position des Steins, der bewegt werden soll
				if(sc.hasNextInt())			
					yStart = sc.nextInt();	// Eingabe Y-Position des Steins, der bewegt werden soll
				if(sc.hasNextInt())
					xZiel = sc.nextInt();	// Eingabe X-Position der Zielpostion
				if(sc.hasNextInt())
					yZiel = sc.nextInt();	// Eingabe Y-Position der Zielpostion

			controller.move(xStart, yStart, xZiel, yZiel);
			
			xStart = 0;
			yStart = 0;
			xZiel = 0;
			yZiel = 0;
			
		}
		System.out.println("ENDE");
	}

	@Override
	public void update(Event e) {
		controller.printField();
	}
}
