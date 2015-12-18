package de.htwg.se.tablut.cmodel;

public interface IField {
	
	/**
	 * 
	 * @return
	 */
	int getOccupied();
	
	/**
	 * 
	 * @param o
	 */
	void setOccupied(int o);
	
	/**
	 * 
	 * @return
	 */
	boolean isVictory();
	
	/**
	 * 
	 * @param v
	 */
	void setVictory(boolean v);
	
	/**
	 * 
	 * @return
	 */
	int getNoHit();
	
	/**
	 * 
	 * @param n
	 */
	void setNoHit(int n);
	
	/**
	 * 
	 * @return
	 */
	Stone getCharakter();
	
	/**
	 * 
	 * @param s
	 */
	void setCharakter(Stone s);
}
