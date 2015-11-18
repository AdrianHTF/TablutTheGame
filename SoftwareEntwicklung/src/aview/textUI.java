package aview;
import bcontroller.*;
import cmodel.Gamefield;

import java.util.Scanner;;

public class textUI {
	private controller controller;
	public static int gameFieldSize = 0;
	
	public textUI(){
		controller = new controller(gameFieldSize);
	}
	
	public static void main(String [] args){
		
		while(gameFieldSize == 0){
			
			System.out.println("Geben sie Eine Feldgroesse an(9, 11, 13)");
			Scanner sc = new Scanner(System.in);
			
			if(sc.hasNextInt()){
				int a = sc.nextInt();
				if(a == 9 || a == 11 || a == 13)
					gameFieldSize = a;
				else
					System.out.println("Erlaubt ist nur 9, 11 oder 13");
			}
			else 
				System.out.println("Falsche Eingabe!");
		}
		
	    textUI ui = new textUI();
		ui.controller.printField();
		
		int xStart = 0;
		int yStart = 0;
		int xZiel = 0;
		int yZiel = 0;
		while(true){
			System.out.println("\n\nBitte geben sie ihren Spielzug an:\n");
			Scanner sc = new Scanner(System.in);
			if(sc.hasNextInt())
				xStart = sc.nextInt();
			if(sc.hasNextInt())
				yStart = sc.nextInt();
			if(sc.hasNextInt())
				xZiel = sc.nextInt();
			if(sc.hasNextInt())
				yZiel = sc.nextInt();
			
			ui.controller.move(xStart, yStart, xZiel, yZiel);
			xStart = 0;
			yStart = 0;
			xZiel = 0;
			yZiel = 0;
			ui.controller.printField();
		}
	}
}
