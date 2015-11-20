package aview;
import bcontroller.*;

import java.util.Scanner;;

public class TextUI {
	private Controller controller;
	private int gameFieldSize = 0;
	
	public TextUI(){
		
	}
	public void setGameFieldSize(int a){
		gameFieldSize = a;
	}
	public int getGameFieldSize(){
		return gameFieldSize;
	}
	public void setController(){
		controller = new Controller(gameFieldSize);
	}
	
	public static void main(String [] args){
		
		TextUI ui = new TextUI();
		
		while(ui.getGameFieldSize() == 0){
			
			System.out.println("Geben sie Eine Feldgroesse an(9, 11, 13)");
			Scanner sc = new Scanner(System.in);
			
			if(sc.hasNextInt()){
				int a = sc.nextInt();
				if(a == 9 || a == 11 || a == 13)
					ui.setGameFieldSize(a);
				else
					System.out.println("Spielfeldgroesse nur in 9*9, 11*11 oder 13*13");
			} else {
				System.out.println("Falsche Eingabe!");
			}
		}
		
	    ui.setController();
		ui.controller.printField();
		
		int xStart = 0;
		int yStart = 0;
		int xZiel = 0;
		int yZiel = 0;
		
		while(ui.controller.winGame() != true){
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

			ui.controller.move(xStart, yStart, xZiel, yZiel);
			xStart = 0;
			yStart = 0;
			xZiel = 0;
			yZiel = 0;
			ui.controller.printField();
			
			
		}
		System.out.println("ENDE");
	}
}
