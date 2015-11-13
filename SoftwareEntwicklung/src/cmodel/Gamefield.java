package cmodel;

/**
 * 
 * @author adrian fien & waldemar brill
 *	in this class we implement the game-field for "Tablut"
 *	the game-field is realized as an array-matrix 
 */
public class Gamefield {

	
	public static field[][] gamefield;
	private int sizeOfGameField = 1;
	

	public Gamefield (int arraysize){
		/**
		 * Denk daran, am Ende die Feldgröße mindestens auf 3 setzen
		 */		
		sizeOfGameField = arraysize;
		if (sizeOfGameField % 2 == 0){
			System.err.println("Fieldsize must be odd");
			return;
		}
		gamefield = new field[sizeOfGameField][sizeOfGameField];
		for (int i = 0; i < sizeOfGameField; i++){
			for (int j = 0; j < sizeOfGameField; j++){
				gamefield[j][i] = new field();
			}
		}
	}
	public field[][] getField(){
		return gamefield;
	}
	public field getField(int xAxis, int yAxis){
		return gamefield[xAxis][yAxis];
	}
	public void setField(field[][] f){
		gamefield = f;
	}
	public int getSizeOfGameField(){
		return sizeOfGameField;
	}
	public void setSizeOfField(int i){
		sizeOfGameField = i;
	}

}
