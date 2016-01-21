package de.htwg.se.tablut.bcontroller;

import de.htwg.se.tablut.cmodel.*;

public interface IHitRule {
	IGamefield hit(IGamefield gamefield, int xAxis, int yAxis);
	boolean getKingVictory();
	void setKingVictory(boolean kingVictory);
	void setStatus(GameStatus s);
}
