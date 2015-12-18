package de.htwg.se.tablut.cmodel;
/**
 * 
 * @author waldemar brill && adrian fien
 *
 */
public class Stone implements IStone {
	private int unitSpecification = 0;
	private static final int ATTACK = 1;
	private static final int DEFENSE = 2;
	private boolean isKing = false;
	/**
	 * 
	 * @param pUnitSpecification 
	 * (0 = attack; 1 = defense; 2 = king)
	 * (attack = white; defense = black; king = purple)
	 */
	public Stone(int pUnitSpecification){
		if(pUnitSpecification == 0)
			unitSpecification = 0;
		else if(pUnitSpecification == 1){
			unitSpecification = ATTACK;
			}
		else if(pUnitSpecification == 2){
			unitSpecification = DEFENSE;
		}
		else if(pUnitSpecification == 3){
			unitSpecification = DEFENSE;
			isKing = true;
		}
		else
			return;
	}
	
	@Override
	public int getUnitSpecification() {
		return unitSpecification;
	}
	
	@Override
	public void setUnitSpecification(int unitSpecification) {
		this.unitSpecification = unitSpecification;
	}
	
	@Override
	public boolean getIsKing(){
		return isKing;
	}
	
	@Override
	public void setIsKing(boolean isKing){
		this.isKing = isKing;
	}
	
}
