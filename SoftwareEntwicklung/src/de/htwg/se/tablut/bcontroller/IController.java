package de.htwg.se.tablut.bcontroller;
import de.htwg.se.tablut.cmodel.*;
import de.htwg.se.tablut.dutil.IObservable;

public interface IController extends IObservable {
	void move(int xS, int yS, int xZ, int yZ);
	boolean winGame();
	boolean winGameAttack();
	boolean getWinGameAttack();
	void setWinGameAttack(boolean w);
	IGamefield getGamefield();
	void setMatrixSize(int size);
	int getMatrixSize();
	boolean getPlayerTurn();
	void undo();
	void redo();
	GameStatus getStatus();
	void setStatus(GameStatus gs);
}
