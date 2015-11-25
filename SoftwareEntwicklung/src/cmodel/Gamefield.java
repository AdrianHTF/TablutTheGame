package cmodel;

/**
 * 
 * @author adrian fien & waldemar brill
 *	in this class we implement the game-field for "Tablut"
 *	the game-field is realized as an array-matrix 
 */
public class Gamefield {

	private Field[][] mainGamefield;
	private int sizeOfGameField = 1;
	

	public Gamefield (int arraysize){
		
		sizeOfGameField = arraysize;
		
		if (sizeOfGameField % 2 == 0){
			System.err.println("Fieldsize must be odd");
			return;
		}
		
		mainGamefield = new Field[sizeOfGameField][sizeOfGameField];
		for (int i = 0; i < sizeOfGameField; i++){
			for (int j = 0; j < sizeOfGameField; j++){
				mainGamefield[i][j] = new Field();
				mainGamefield[i][j].setCharakter(new Stone(0));
				mainGamefield[i][j].setOccupied(0);
				mainGamefield[i][j].setVictory(false);
			}
		}
		setStandard();
		setStartfieldAttack();
		setStartfieldDefense();
	}
	public Field[][] getGameField(){
		return mainGamefield;
	}
	public Field getField(int xAxis, int yAxis){
		return mainGamefield[xAxis][yAxis];
	}
	public void setGameField(Field[][] f){
		mainGamefield = f;
	}
	public int getSizeOfGameField(){
		return sizeOfGameField;
	}
	public void setSizeOfField(int i){
		sizeOfGameField = i;
	}
	public void setStandard(){
		mainGamefield[0][0].setVictory(true);
		mainGamefield[0][0].setOccupied(1);
		
		mainGamefield[sizeOfGameField-1][0].setVictory(true);
		mainGamefield[sizeOfGameField-1][0].setOccupied(1);
		
		mainGamefield[0][sizeOfGameField-1].setVictory(true);
		mainGamefield[0][sizeOfGameField-1].setOccupied(1);
		
		mainGamefield[sizeOfGameField-1][sizeOfGameField-1].setVictory(true);
		mainGamefield[sizeOfGameField-1][sizeOfGameField-1].setOccupied(1);
		
		mainGamefield[sizeOfGameField/2][sizeOfGameField/2].setOccupied(1);
		
		mainGamefield[sizeOfGameField/2][sizeOfGameField/2].setCharakter(new Stone(3));
	}
	
	public void setStartfieldAttack(){
		int max = sizeOfGameField-1;
		int middle = max/2;
		int min = 0;
		//----------ATK-----------------
		if (sizeOfGameField == 9){
			mainGamefield[middle][min].setCharakter(new Stone(1));
			mainGamefield[middle-1][min].setCharakter(new Stone(1));
			mainGamefield[middle+1][min].setCharakter(new Stone(1));
			mainGamefield[middle][min+1].setCharakter(new Stone(1));
			
			mainGamefield[max][middle].setCharakter(new Stone(1));
			mainGamefield[max][middle-1].setCharakter(new Stone(1));
			mainGamefield[max][middle+1].setCharakter(new Stone(1));
			mainGamefield[max-1][middle].setCharakter(new Stone(1));
					
			mainGamefield[middle][max].setCharakter(new Stone(1));
			mainGamefield[middle-1][max].setCharakter(new Stone(1));
			mainGamefield[middle+1][max].setCharakter(new Stone(1));
			mainGamefield[middle][max-1].setCharakter(new Stone(1));
			
			mainGamefield[min][middle].setCharakter(new Stone(1));
			mainGamefield[min][middle-1].setCharakter(new Stone(1));
			mainGamefield[min][middle+1].setCharakter(new Stone(1));
			mainGamefield[min+1][middle].setCharakter(new Stone(1));
		}else{
			placeAtk();
		}
	}
	public void setStartfieldDefense(){
		//---------------DEF---------------
		int max = sizeOfGameField-1;
		int middle = max/2;
		int[] forLoopIteratField = {-3, -2, -1, 1, 2, 3 , 4};
		int firstElementInForLoopA = 2;
		int firstElementinForLoopB = 1;
		int stopForLoopWaiter = 3;
		if (sizeOfGameField == 9 || sizeOfGameField == 11 || sizeOfGameField == 13){

			if(sizeOfGameField == 13){
				firstElementinForLoopB = 0;
				stopForLoopWaiter = 4;
			}
			for (int i = forLoopIteratField[firstElementinForLoopB]; i < stopForLoopWaiter; i = forLoopIteratField[firstElementinForLoopB++]){
				mainGamefield[middle+i][middle].setCharakter(new Stone(2));
				mainGamefield[middle][middle+i].setCharakter(new Stone(2));
			}
			if (sizeOfGameField == 11){
				for (int i = forLoopIteratField[2]; i < 2 ; i = forLoopIteratField[firstElementInForLoopA++]){
					mainGamefield[middle+i][middle+i].setCharakter(new Stone(2));
					mainGamefield[middle-i][middle+i].setCharakter(new Stone(2));
				}
			}
		}
	}
	
	public void placeAtk(){
		int max = sizeOfGameField-1;
		int middle = max/2;
		int min = 0;
		
		mainGamefield[middle][min].setCharakter(new Stone(1));
		mainGamefield[middle-1][min].setCharakter(new Stone(1));
		mainGamefield[middle+1][min].setCharakter(new Stone(1));
		mainGamefield[middle-2][min].setCharakter(new Stone(1));
		mainGamefield[middle+2][min].setCharakter(new Stone(1));
		mainGamefield[middle][min+1].setCharakter(new Stone(1));
		
		mainGamefield[max][middle].setCharakter(new Stone(1));
		mainGamefield[max][middle-1].setCharakter(new Stone(1));
		mainGamefield[max][middle+1].setCharakter(new Stone(1));
		mainGamefield[max][middle-2].setCharakter(new Stone(1));
		mainGamefield[max][middle+2].setCharakter(new Stone(1));
		mainGamefield[max-1][middle].setCharakter(new Stone(1));
		
		mainGamefield[middle][max].setCharakter(new Stone(1));
		mainGamefield[middle-1][max].setCharakter(new Stone(1));
		mainGamefield[middle+1][max].setCharakter(new Stone(1));
		mainGamefield[middle-2][max].setCharakter(new Stone(1));
		mainGamefield[middle+2][max].setCharakter(new Stone(1));
		mainGamefield[middle][max-1].setCharakter(new Stone(1));
		
		mainGamefield[min][middle].setCharakter(new Stone(1));
		mainGamefield[min][middle-1].setCharakter(new Stone(1));
		mainGamefield[min][middle+1].setCharakter(new Stone(1));
		mainGamefield[min][middle-2].setCharakter(new Stone(1));
		mainGamefield[min][middle+2].setCharakter(new Stone(1));
		mainGamefield[min+1][middle].setCharakter(new Stone(1));
	}

}
