package cmodel;
/**
 * 
 * @author waldemar brill && adrian fien
 *
 */
public class stone {
	
	private int unitSpecification = 0;
	private final int attack = 1;
	private final int defense = 2;
	private final int king = 3;
	/**
	 * 
	 * @param pUnitSpecification 
	 * (0 = attack; 1 = defense; 2 = king)
	 * (attack = white; defense = black; king = purple)
	 */
	public stone(int pUnitSpecification){
		if(pUnitSpecification == 0)
			unitSpecification = 0;
		else if(pUnitSpecification == 1)
			unitSpecification = attack;
		else if(pUnitSpecification == 2)
			unitSpecification = defense;
		else if(pUnitSpecification == 3)
			unitSpecification = king;
		else
			System.err.println("Unit must be 1, 2 or 3");
	}
	public int getUnitSpecification() {
		return unitSpecification;
	}
	public void setUnitSpecification(int unitSpecification) {
		this.unitSpecification = unitSpecification;
	}
}
