package de.htwg.se.tablut.bcontroller.impl;

import de.htwg.se.tablut.bcontroller.IRules;
import de.htwg.se.tablut.cmodel.*;
import de.htwg.se.tablut.cmodel.impl.Stone;

public class Rules implements IRules{
	@Override
	public boolean drawRules(IGamefield gamefield,
			Stone drawStone, Stone changeStone,
			int xStart, int xZiel, int yStart, int yZiel){
		
		if((xStart == xZiel && yStart == yZiel) 
			|| (xStart != xZiel && yStart != yZiel) 
			|| (gamefield.getField(xZiel, yZiel).getOccupied() == 1 && !drawStone.getIsKing())
			|| (changeStone.getUnitSpecification() != 0)){
				return false;
			} else {
				if(xStart == xZiel && !yMove(gamefield, xStart, yStart, yZiel)){
					return false;
				} else if(yStart == yZiel && !xMove(gamefield, xStart, xZiel, yStart)){
					return false;
				}
				return true;
			}
	}
	@Override
	public boolean yourTurn(boolean playerTurn, IGamefield gamefield,
			int xStart, int yStart){
		if (playerTurn){
			if(gamefield.getField(xStart, yStart).getCharakter().getUnitSpecification() == 1){
				return true;
			}
		}else{
			if(gamefield.getField(xStart, yStart).getCharakter().getUnitSpecification() > 1){
				return true;
			}
		}
		return false;
	}
	
	@Override
	public boolean yMove(IGamefield gamefield,
			int xStart, int yStart, int yZiel){
		if(yStart < yZiel){
			for(int i = yStart + 1; i <= yZiel; i++){
				if (gamefield.getField(xStart, i).getCharakter().getUnitSpecification() > 0){
					return false;
				}
			}
		} else{
			for(int i = yStart - 1; i >= yZiel; i--){
				if (gamefield.getField(xStart, i).getCharakter().getUnitSpecification() > 0){
					return false;
				}
			}
		}
		return true;
	}
	@Override
	public boolean xMove(IGamefield gamefield,
			int xStart, int xZiel,  int yStart){
		if(xStart < xZiel){
			for (int i = xStart+1; i <= xZiel; i++){
				if (gamefield.getField(i, yStart).getCharakter().getUnitSpecification() > 0){
					return false;
				}
			}
		}else{
			for(int j = xStart-1; j >= xZiel; j--){
				if (gamefield.getField(j, yStart).getCharakter().getUnitSpecification() > 0){
					return false;
				}
			}
		}
		return true;
	}
	

}
