package de.htwg.se.tablut.bcontroller.impl;
import de.htwg.se.tablut.bcontroller.IController;
import de.htwg.se.tablut.bcontroller.IHitRule;
import de.htwg.se.tablut.bcontroller.IRules;
import de.htwg.se.tablut.cmodel.*;
import de.htwg.se.tablut.cmodel.impl.*;
import de.htwg.se.tablut.dutil.impl.Observable;
import de.htwg.se.tablut.bcontroller.GameStatus;
import de.htwg.se.tablut.aview.StatusMessage;
import java.util.logging.Logger;
import java.util.Stack;
import com.google.inject.Inject;

public class Controller extends Observable implements IController{
	
	private GameStatus status = GameStatus.WELCOME;
	private IGamefield gamefield;
	private IRules rule;
	private IHitRule hitrule;
	private boolean playerTurn = true;
	private boolean winGameAttack = false;
	private int matrixSize = 0;
	private static final Logger LOGGER = Logger.getLogger(Controller.class.getName());
	private Stack<IGamefield> undoList = new Stack<>();
	private Stack<IGamefield> redoList = new Stack<>();
	
	@Inject
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
			setStatus(GameStatus.MOVE_SUCCESS);
			undoPush();
			redoList.clear();
			if(xStart == gamefield.getSizeOfGameField()/2 && yStart == gamefield.getSizeOfGameField()/2){
				gamefield.getField(xStart, yStart).setOccupied(1);
			} else {
				gamefield.getField(xStart, yStart).setOccupied(0);
			}
			gamefield = hitrule.hit(gamefield, xZiel, yZiel);
			playerTurn = !playerTurn;
		} else 
			setStatus(GameStatus.MOVE_FAILE);
		notifyObservers();
	}
	
	@Override
	public boolean winGame(){
		if((gamefield.getField(gamefield.getSizeOfGameField()-1, gamefield.getSizeOfGameField()-1).getCharakter().getIsKing())
				|| (gamefield.getField(0, gamefield.getSizeOfGameField()-1).getCharakter().getIsKing())
				|| (gamefield.getField(gamefield.getSizeOfGameField()-1, 0).getCharakter().getIsKing())
				|| (gamefield.getField(0, 0).getCharakter().getIsKing())){
			setStatus(GameStatus.WINGAME_DEFENSE);
			return false;
			
		} else
		return true;
	}
	
	@Override
	public boolean winGameAttack(){
		if(hitrule.getKingVictory()){
			setStatus(GameStatus.WINGAME_ATTACK);
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
	public IGamefield getGamefield(){
		return gamefield;
	}
	
	@Override
	public void setMatrixSize(int size){
		matrixSize = size;
		gamefield.setStart(matrixSize);
		setStatus(GameStatus.CREATE);
		undoPush();
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
	
	public void undoPush(){
		IGamefield c = new Gamefield();
		c = gamefield;
		undoList.push(c);
	}
	
	@Override
	public void undo(){
		if(!undoList.isEmpty()){
			IGamefield g = undoList.pop();
			gamefield = g;
			redoList.add(g);
			notifyObservers();
		}
	}
	
	@Override
	public void redo(){
		if(!redoList.isEmpty()){
			gamefield = redoList.pop();
			notifyObservers();
		}
	}
	
	@Override
	public GameStatus getStatus() {
		return status;
	}

	@Override
	public void setStatus(GameStatus status) {
		this.status = status;
		LOGGER.info(StatusMessage.text.get(status));
	}
}