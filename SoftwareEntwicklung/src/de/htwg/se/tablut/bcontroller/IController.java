package de.htwg.se.tablut.bcontroller;

public interface IController {
	int sizeOfMatrix();
	void printField();
	void move(int xS, int yS, int xZ, int yZ);
	boolean winGame();
	boolean winGameAttack();
	boolean getWinGameAttack();
	void setWinGameAttack(boolean w);
}
