package de.htwg.se.tablut.bcontroller;
import java.util.Scanner;
import de.htwg.se.tablut.cmodel.*;
import de.htwg.se.tablut.util.*;

public class Controller extends Observable implements IController{
	
	private Gamefield gamefield;
	private Rules rule;
	private HitRule hitrule;
	private boolean playerTurn = true;
	private boolean winGameAttack = false;
	
	public Controller(){
		gamefield = new Gamefield();
		gamefield.setStart(sizeOfMatrix());
		rule = new Rules();
		hitrule = new HitRule();
	}
	
	public Controller(int arraysize){
		gamefield = new Gamefield();
		gamefield.setStart(arraysize);
		rule = new Rules();
		hitrule = new HitRule();
	}
	
	@Override
	public int sizeOfMatrix(){
		while(gamefield.getSizeOfGameField() == 0){
			
			System.out.println("Geben sie Eine Feldgroesse an(9, 11, 13)");
			Scanner sc = new Scanner(System.in);
			
			if(sc.hasNextInt()){
				int a = sc.nextInt();
				if(a == 9 || a == 11 || a == 13){
					return a;
				}
				else{
					System.out.println("Spielfeldgroesse nur in 9*9, 11*11 oder 13*13");
				}
			} else {
				System.out.println("Falsche Eingabe!");
			}
		}
		return 0;
	}
	
	@Override
	public void printField(){
		for (int i = 0; i < gamefield.getSizeOfGameField(); i++){
			for (int j = 0; j< gamefield.getSizeOfGameField(); j++){
				if((j % gamefield.getSizeOfGameField()) == 0)
					System.out.println("\n");
				System.out.print(gamefield.getField(j, i));
			}
		}
	}
	
	@Override
	public void move(int xStart, int yStart, int xZiel, int yZiel){
		Stone drawStone = gamefield.getField(xStart, yStart).getCharakter();
		Stone changeStone = gamefield.getField(xZiel, yZiel).getCharakter();
		if(rule.yourTurn(playerTurn, gamefield, xStart, yStart)
				&& rule.drawRules(gamefield, drawStone, changeStone, xStart, xZiel, yStart, yZiel)){
			gamefield.getField(xStart, yStart).setCharakter(changeStone);
			gamefield.getField(xZiel, yZiel).setCharakter(drawStone);
			if(xStart == gamefield.getSizeOfGameField()/2 && yStart == gamefield.getSizeOfGameField()/2){
				gamefield.getField(xStart, yStart).setOccupied(1);
			} else {
				gamefield.getField(xStart, yStart).setOccupied(0);
			}
			gamefield = hitrule.hit(gamefield, xZiel, yZiel);
			playerTurn = !playerTurn;
		}
		notifyObservers();
	}
	
	@Override
	public boolean winGame(){
		// Siegbedingung für den Verteidiger
		if((gamefield.getField(gamefield.getSizeOfGameField()-1, gamefield.getSizeOfGameField()-1).getCharakter().getIsKing())
				|| (gamefield.getField(0, gamefield.getSizeOfGameField()-1).getCharakter().getIsKing())
				|| (gamefield.getField(gamefield.getSizeOfGameField()-1, 0).getCharakter().getIsKing())
				|| (gamefield.getField(0, 0).getCharakter().getIsKing())){
			System.out.println("\nVerteidiger hat gewonnen!\n");
			return false;
			
		} else
		return true;
	}
	
	@Override
	public boolean winGameAttack(){
		if(hitrule.getKingVictory()){
			System.out.println("\nAngreifer hat gewonnen!\n");
			return false;
		}
		return true;
	}
	
	@Override
	public boolean getWinGameAttack(){
		return winGameAttack;
	}
	
	@Override
	public void setWinGameAttack(boolean winGameAttack){
		this.winGameAttack = winGameAttack;
	}
}