package de.htwg.se.tablut.bcontroller;
import de.htwg.se.tablut.cmodel.*;

public interface IController {
	int sizeOfMatrix();
	void funktion();
	void move(int xS, int yS, int xZ, int yZ);
	boolean winGame();
	boolean winGameAttack();
	boolean getWinGameAttack();
	void setWinGameAttack(boolean w);
	Gamefield getGamefield();
}
