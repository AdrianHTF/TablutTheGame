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
		setStandard();
		setStartfield();
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
	public void setStandard(){
		gamefield[0][0].setVictory(true);
		gamefield[0][0].setOccupied(1);
		
		gamefield[sizeOfGameField-1][0].setVictory(true);
		gamefield[sizeOfGameField-1][0].setOccupied(1);
		
		gamefield[0][sizeOfGameField-1].setVictory(true);
		gamefield[0][sizeOfGameField-1].setOccupied(1);
		
		gamefield[sizeOfGameField-1][sizeOfGameField-1].setVictory(true);
		gamefield[sizeOfGameField-1][sizeOfGameField-1].setOccupied(1);
		
		gamefield[sizeOfGameField/2][sizeOfGameField/2].setOccupied(1);
		
		gamefield[sizeOfGameField/2][sizeOfGameField/2].setCharakter(new stone(3));
	}
	public void setStartfield(){
		int max = sizeOfGameField-1;
		int middle = max/2;
		int min = 0;
		//----------ATK-----------------
		if (sizeOfGameField == 9){
			gamefield[middle][min].setCharakter(new stone(1));
			gamefield[middle-1][min].setCharakter(new stone(1));
			gamefield[middle+1][min].setCharakter(new stone(1));
			gamefield[middle][min+1].setCharakter(new stone(1));
			
			gamefield[max][middle].setCharakter(new stone(1));
			gamefield[max][middle-1].setCharakter(new stone(1));
			gamefield[max][middle+1].setCharakter(new stone(1));
			gamefield[max-1][middle].setCharakter(new stone(1));
			
			gamefield[middle][max].setCharakter(new stone(1));
			gamefield[middle-1][max].setCharakter(new stone(1));
			gamefield[middle+1][max].setCharakter(new stone(1));
			gamefield[middle][max-1].setCharakter(new stone(1));
			
			gamefield[min][middle].setCharakter(new stone(1));
			gamefield[min][middle-1].setCharakter(new stone(1));
			gamefield[min][middle+1].setCharakter(new stone(1));
			gamefield[min+1][middle].setCharakter(new stone(1));
		}else{
			placeAtk();
		}
		//---------------DEF---------------
		if (sizeOfGameField == 9){
			for (int i = -2; i < 3; i++){
				if (i != 0){
					gamefield[middle+i][middle].setCharakter(new stone(2));
					gamefield[middle][middle+i].setCharakter(new stone(2));
				}
			}
		}
		
		if (sizeOfGameField == 11){
			for (int i = -2; i < 3; i++){
				if (i != 0){
					gamefield[middle+i][middle].setCharakter(new stone(2));
					gamefield[middle][middle+i].setCharakter(new stone(2));
				}
			}
			for (int i = -1; i < 2; i++){
				if (i != 0){
					gamefield[middle+i][middle+i].setCharakter(new stone(2));
					gamefield[middle-i][middle+i].setCharakter(new stone(2));
				}
			}
		}
		
		if (sizeOfGameField == 13){
			for (int i = -3; i < 4; i++){
				if (i != 0){
					gamefield[middle+i][middle].setCharakter(new stone(2));
					gamefield[middle][middle+i].setCharakter(new stone(2));
				}
			}
		}
	}
	
	public void placeAtk(){
		int max = sizeOfGameField-1;
		int middle = max/2;
		int min = 0;
		
		gamefield[middle][min].setCharakter(new stone(1));
		gamefield[middle-1][min].setCharakter(new stone(1));
		gamefield[middle+1][min].setCharakter(new stone(1));
		gamefield[middle-2][min].setCharakter(new stone(1));
		gamefield[middle+2][min].setCharakter(new stone(1));
		gamefield[middle][min+1].setCharakter(new stone(1));
		
		gamefield[max][middle].setCharakter(new stone(1));
		gamefield[max][middle-1].setCharakter(new stone(1));
		gamefield[max][middle+1].setCharakter(new stone(1));
		gamefield[max][middle-2].setCharakter(new stone(1));
		gamefield[max][middle+2].setCharakter(new stone(1));
		gamefield[max-1][middle].setCharakter(new stone(1));
		
		gamefield[middle][max].setCharakter(new stone(1));
		gamefield[middle-1][max].setCharakter(new stone(1));
		gamefield[middle+1][max].setCharakter(new stone(1));
		gamefield[middle-2][max].setCharakter(new stone(1));
		gamefield[middle+2][max].setCharakter(new stone(1));
		gamefield[middle][max-1].setCharakter(new stone(1));
		
		gamefield[min][middle].setCharakter(new stone(1));
		gamefield[min][middle-1].setCharakter(new stone(1));
		gamefield[min][middle+1].setCharakter(new stone(1));
		gamefield[min][middle-2].setCharakter(new stone(1));
		gamefield[min][middle+2].setCharakter(new stone(1));
		gamefield[min+1][middle].setCharakter(new stone(1));
	}

}
