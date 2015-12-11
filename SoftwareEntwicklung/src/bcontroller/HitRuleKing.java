package bcontroller;

import cmodel.*;
public class HitRuleKing {
	private Gamefield gamefield;
	public HitRuleKing(){
		
	}
	
	private boolean HitRuleKingUpper(int xAxis, int yAxis){
		if(!characterException(xAxis + 1, yAxis))
			return true;
		return equalsThrone(xAxis + 1, yAxis);
	}
	
	private boolean HitRuleKingLower(int xAxis, int yAxis){
		if(!characterException(xAxis - 1, yAxis))
			return true;
		return equalsThrone(xAxis - 1, yAxis);
	}
	
	private boolean HitRuleKingLeft(int xAxis, int yAxis){
		if(!characterException(xAxis, yAxis - 1))
			return true;
		return equalsThrone(xAxis, yAxis - 1);
	}
	
	private boolean HitRuleKingRight(int xAxis, int yAxis){
		if(!characterException(xAxis, yAxis + 1))
			return true;
		return equalsThrone(xAxis, yAxis + 1);
	}
	
	private boolean equalsThrone(int xAxis, int yAxis){
		if(gamefield.getField(xAxis, yAxis).getCharakter().getUnitSpecification() == 1
				|| gamefield.getField(xAxis, yAxis).equals(gamefield.getField(gamefield.getSizeOfGameField()/2, gamefield.getSizeOfGameField()/2)))
			return true;
		return false;
	}
	
	public boolean kingHit(Gamefield gamefield, int xAxis, int yAxis){
		this.gamefield = gamefield;
		if(gamefield.getField(xAxis, yAxis).getCharakter().getIsKing()){
			if((HitRuleKingLeft(xAxis, yAxis) == true && HitRuleKingLower(xAxis, yAxis) == true 
					&& HitRuleKingRight(xAxis, yAxis) == true && HitRuleKingUpper(xAxis, yAxis) == true))
				return true;
			else
				return false;
		}
		return false;
	}
	
	
	private boolean characterException(int xAxis, int yAxis){
		try{
			gamefield.getField(xAxis, yAxis).getCharakter().getUnitSpecification();
			return true;
		} catch(Exception e){
			return false;
		}
	}
}
