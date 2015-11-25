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
		if(rule.yourTurn(playerTurn, gamefield, xStart, yStart)
				&& rule.drawRules(gamefield, drawStone, changeStone, xStart, xZiel, yStart, yZiel)){
			gamefield.getField(xStart, yStart).setCharakter(changeStone);
			gamefield.getField(xZiel, yZiel).setCharakter(drawStone);
			playerTurn = !playerTurn;
		}

	}
	
	public void hitStoneHorizontal(int xAxis, int yAxis){
		if(rule.hitHorizontalRight(gamefield, xAxis, yAxis)){
			gamefield.getField(xAxis + 1, yAxis).setCharakter(new Stone(0));
		} else if(rule.hitHorizontalLeft(gamefield, xAxis, yAxis)){
			gamefield.getField(xAxis - 1, yAxis).setCharakter(new Stone(0));
		}
	}
	
	public void hitStoneHorizontalDouble(int xAxis, int yAxis){
		if(rule.hitHorizontalRight(gamefield, xAxis, yAxis) && rule.hitHorizontalLeft(gamefield, xAxis, yAxis)){
			gamefield.getField(xAxis + 1, yAxis).setCharakter(new Stone(0));
			gamefield.getField(xAxis - 1, yAxis).setCharakter(new Stone(0));
		}
	}
	
	public void hitStoneVertical(int xAxis, int yAxis){
		if(rule.hitVerticalUpper(gamefield, xAxis, yAxis)){
			gamefield.getField(xAxis, yAxis - 1).setCharakter(new Stone(0));
		} else if(rule.hitVerticalLower(gamefield, xAxis, yAxis)){
			gamefield.getField(xAxis, yAxis + 1).setCharakter(new Stone(0));
		}
	}
	
	public void hitStoneVerticalDouble(int xAxis, int yAxis){
		if(rule.hitVerticalLower(gamefield, xAxis, yAxis) && rule.hitVerticalUpper(gamefield, xAxis, yAxis)){
			gamefield.getField(xAxis, yAxis - 1).setCharakter(new Stone(0));
			gamefield.getField(xAxis, yAxis + 1).setCharakter(new Stone(0));
		}
	}
	
	public boolean winGame(){
		// Siegbedingung für den Verteidiger
		if((gamefield.getField(gamefield.getSizeOfGameField()-1, gamefield.getSizeOfGameField()-1).getCharakter().getUnitSpecification() == 3)
				|| (gamefield.getField(0, gamefield.getSizeOfGameField()-1).getCharakter().getUnitSpecification() == 3)
				|| (gamefield.getField(gamefield.getSizeOfGameField()-1, 0).getCharakter().getUnitSpecification() == 3)
				|| (gamefield.getField(0, 0).getCharakter().getUnitSpecification() == 3)){
			System.out.println("\nVerteidiger hat gewonnen!\n");
			return false;
			
		} else
		return true;
	}
}