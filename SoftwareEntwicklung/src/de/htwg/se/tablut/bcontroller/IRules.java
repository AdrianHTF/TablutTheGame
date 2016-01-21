package de.htwg.se.tablut.bcontroller;

import de.htwg.se.tablut.cmodel.*;
import de.htwg.se.tablut.cmodel.impl.Stone;

public interface IRules {
	boolean drawRules(IGamefield gamefield,
			Stone drawStone, Stone changeStone,
			int xStart, int xZiel, int yStart, int yZiel);
	boolean yourTurn(boolean playerTurn, IGamefield gamefield,
			int xStart, int yStart);
	boolean yMove(IGamefield gamefield,
			int xStart, int yStart, int yZiel);
	boolean xMove(IGamefield gamefield,
			int xStart, int xZiel,  int yStart);
}
