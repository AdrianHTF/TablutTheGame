package bcontroller;
import cmodel.*;

public class Controller{
	
	private Gamefield gamefield;
	private Rules rule;
	private boolean playerTurn = true;
	
	public Controller(int sizeOfMatrix){
		gamefield = new Gamefield(sizeOfMatrix);
		rule = new Rules();
	}
	public void printField(){
		for (int i = 0; i < gamefield.getSizeOfGameField(); i++){
			for (int j = 0; j< gamefield.getSizeOfGameField(); j++){
				if((j % gamefield.getSizeOfGameField()) == 0)
					System.out.println("\n");
				System.out.print(gamefield.getField(j, i));
			}
		}
	}
	
	public void move(int xStart, int yStart, int xZiel, int yZiel){
		Stone drawStone;
		Stone changeStone;
		drawStone = gamefield.getField(xStart, yStart).getCharakter();
		changeStone = gamefield.getField(xZiel, yZiel).getCharakter();
		if(rule.yourTurn(playerTurn, gamefield, xStart, yStart)){
			if(rule.drawRules(gamefield, drawStone, changeStone, xStart, xZiel, yStart, yZiel)){
				gamefield.getField(xStart, yStart).setCharakter(changeStone);
				gamefield.getField(xZiel, yZiel).setCharakter(drawStone);
				playerTurn = !playerTurn;
			}
		}

	}
	public boolean winGame(){
		// Siegbedingung für den Verteidiger
		if((gamefield.getField(gamefield.getSizeOfGameField()-1, gamefield.getSizeOfGameField()-1).getCharakter().getUnitSpecification() == 3)
				|| (gamefield.getField(0, gamefield.getSizeOfGameField()-1).getCharakter().getUnitSpecification() == 3)
				|| (gamefield.getField(gamefield.getSizeOfGameField()-1, 0).getCharakter().getUnitSpecification() == 3)
				|| (gamefield.getField(0, 0).getCharakter().getUnitSpecification() == 3)){
			System.out.println("\nVerteidiger hat gewonnen!\n");
			return true;
			
		} else
		return false;
	}
}