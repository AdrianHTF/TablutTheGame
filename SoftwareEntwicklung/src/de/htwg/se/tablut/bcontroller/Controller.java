package de.htwg.se.tablut.bcontroller;
import de.htwg.se.tablut.cmodel.*;
import de.htwg.se.tablut.dutil.*;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Controller extends Observable implements IController{
	
	private Gamefield gamefield;
	private Rules rule;
	private HitRule hitrule;
	private boolean playerTurn = true;
	private boolean winGameAttack = false;
	private int matrixSize = 0;
	private static final Logger LOGGER = Logger.getLogger(Controller.class.getName());
	
	public Controller(){
		gamefield = new Gamefield();
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
		if((gamefield.getField(gamefield.getSizeOfGameField()-1, gamefield.getSizeOfGameField()-1).getCharakter().getIsKing())
				|| (gamefield.getField(0, gamefield.getSizeOfGameField()-1).getCharakter().getIsKing())
				|| (gamefield.getField(gamefield.getSizeOfGameField()-1, 0).getCharakter().getIsKing())
				|| (gamefield.getField(0, 0).getCharakter().getIsKing())){
			LOGGER.setLevel(Level.FINEST);
			LOGGER.info("\nVerteidiger hat gewonnen!");
			//System.out.println("\nVerteidiger hat gewonnen!\n");
			return false;
			
		} else
		return true;
	}
	
	@Override
	public boolean winGameAttack(){
		if(hitrule.getKingVictory()){
			LOGGER.info("\n Angreifer hat gewonnen!");
			//System.out.println("\nAngreifer hat gewonnen!\n");
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
	
	@Override
	public Gamefield getGamefield(){
		return gamefield;
	}
	
	@Override
	public void setMatrixSize(int size){
		matrixSize = size;
		gamefield.setStart(matrixSize);
		notifyObservers();
	}
	
	@Override
	public int getMatrixSize(){
		return matrixSize;
	}
	
	@Override
	public boolean getPlayerTurn(){
		return playerTurn;
	}
}