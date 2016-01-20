package de.htwg.se.tablut.bcontroller.impl;

import de.htwg.se.tablut.bcontroller.IHitRule;
import de.htwg.se.tablut.bcontroller.IHitRuleKing;
import de.htwg.se.tablut.cmodel.*;
import de.htwg.se.tablut.cmodel.impl.Stone;

public class HitRule implements IHitRule{
	
	
	private IGamefield changedGamefield;
	private int xAxis;
	private int yAxis;
	private boolean kingVictory = false;
	private IHitRuleKing hk = new HitRuleKing(); 
	
	public HitRule(){
		
	}
	
	@Override
	public IGamefield hit(IGamefield gamefield, int xAxis, int yAxis){
		this.xAxis = xAxis;
		this.yAxis = yAxis;
		changedGamefield = gamefield;
		int x = changedGamefield.getField(xAxis, yAxis).getNoHit();
		if(!(xAxis == 0 || yAxis == 0 
				|| xAxis == changedGamefield.getSizeOfGameField() - 1
				|| yAxis == changedGamefield.getSizeOfGameField() - 1)){
			
			setKingVictory(hk.kingHit(changedGamefield, xAxis, yAxis - 1));
			setKingVictory(hk.kingHit(changedGamefield, xAxis, yAxis + 1));
			setKingVictory(hk.kingHit(changedGamefield, xAxis - 1, yAxis));
			setKingVictory(hk.kingHit(changedGamefield, xAxis + 1, yAxis));
		}
		
		switch(x){
			case 0:
				hitable0();
				break;
			case 1:
				hitable1();
				break;
			case 2:
				hitable2();
				break;
			case 3:
				hitable3();
				break;
			case 4:
				hitable4();
				break;
			case 5:
				hitable5();
				break;
			case 6:
				hitable6();
				break;
			case 7:
				hitable7();
				break;
			case 8:
				hitable8();
				break;
			default:
				break;
		}
		return changedGamefield;
		
	}

	private void hitable0(){
		hitTop();
		hitRight();
		hitLeft();
		hitBott();
	}
	private void hitable1(){
		hitRight();
		hitLeft();
		hitBott();
	}
	private void hitable2(){
		hitLeft();
		hitBott();
	}
	private void hitable3(){
		hitTop();
		hitLeft();
		hitBott();
	}
	private void hitable4(){
		hitTop();
		hitLeft();
	}
	private void hitable5(){
		hitTop();
		hitRight();
		hitLeft();
	}
	private void hitable6(){
		hitTop();
		hitRight();
	}
	private void hitable7(){
		hitTop();
		hitRight();
		hitBott();
	}
	private void hitable8(){
		hitRight();
		hitBott();
	}
	
	private void hitTop(){
		if(changedGamefield.getField(xAxis, yAxis - 1).getCharakter().getIsKing())
			setKingVictory(hk.kingHit(changedGamefield, xAxis, yAxis - 1));
		else {
			if((changedGamefield.getField(xAxis, yAxis - 1).getCharakter().getUnitSpecification() != 0 
					&& (changedGamefield.getField(xAxis, yAxis).getCharakter().getUnitSpecification() 
							!= changedGamefield.getField(xAxis, yAxis - 1).getCharakter().getUnitSpecification())
							&& !changedGamefield.getField(xAxis, yAxis - 1).getCharakter().getIsKing()) 
					&& (changedGamefield.getField(xAxis , yAxis - 2).getCharakter().getUnitSpecification() 
							== changedGamefield.getField(xAxis, yAxis).getCharakter().getUnitSpecification()))
			changedGamefield.getField(xAxis, yAxis - 1).setCharakter(new Stone(0));
		}
	}
	
	private void hitRight(){
		if(changedGamefield.getField(xAxis + 1, yAxis).getCharakter().getIsKing())
			setKingVictory(hk.kingHit(changedGamefield, xAxis + 1, yAxis));
		else{
			if((changedGamefield.getField(xAxis + 1 , yAxis).getCharakter().getUnitSpecification() != 0
					&& (changedGamefield.getField(xAxis, yAxis).getCharakter().getUnitSpecification() 
							!= changedGamefield.getField(xAxis + 1, yAxis).getCharakter().getUnitSpecification())
					&& !changedGamefield.getField(xAxis + 1, yAxis).getCharakter().getIsKing())
					&& (changedGamefield.getField(xAxis + 2 , yAxis).getCharakter().getUnitSpecification() 
						== changedGamefield.getField(xAxis, yAxis).getCharakter().getUnitSpecification()))
				changedGamefield.getField(xAxis + 1, yAxis).setCharakter(new Stone(0));
		}
	}
	
	private void hitLeft(){
		if(changedGamefield.getField(xAxis - 1, yAxis).getCharakter().getIsKing())
			setKingVictory(hk.kingHit(changedGamefield, xAxis - 1, yAxis));
		else {
			if((changedGamefield.getField(xAxis - 1 , yAxis).getCharakter().getUnitSpecification() != 0
					&& (changedGamefield.getField(xAxis, yAxis).getCharakter().getUnitSpecification() 
							!= changedGamefield.getField(xAxis - 1, yAxis).getCharakter().getUnitSpecification())
							&& !changedGamefield.getField(xAxis - 1, yAxis).getCharakter().getIsKing())
					&& (changedGamefield.getField(xAxis - 2 , yAxis).getCharakter().getUnitSpecification()
							== changedGamefield.getField(xAxis, yAxis).getCharakter().getUnitSpecification()))
				changedGamefield.getField(xAxis - 1, yAxis).setCharakter(new Stone(0));
		}
	}
	
	private void hitBott(){
		if(changedGamefield.getField(xAxis, yAxis + 1).getCharakter().getIsKing())
			setKingVictory(hk.kingHit(changedGamefield, xAxis, yAxis + 1));
		else{
			if((changedGamefield.getField(xAxis, yAxis + 1).getCharakter().getUnitSpecification() != 0 
					&& (changedGamefield.getField(xAxis, yAxis).getCharakter().getUnitSpecification() 
							!= changedGamefield.getField(xAxis, yAxis + 1).getCharakter().getUnitSpecification())
							&& !changedGamefield.getField(xAxis, yAxis + 1).getCharakter().getIsKing())
					&& (changedGamefield.getField(xAxis , yAxis + 2).getCharakter().getUnitSpecification() 
							== changedGamefield.getField(xAxis, yAxis).getCharakter().getUnitSpecification()))
				changedGamefield.getField(xAxis, yAxis + 1).setCharakter(new Stone(0));
		}
	}
	
	@Override
	public boolean getKingVictory(){
		return kingVictory;
	}
	
	@Override
	public void setKingVictory(boolean kingVictory){
		if(!this.kingVictory)
			this.kingVictory = kingVictory;
	}

}
