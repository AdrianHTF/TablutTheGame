package cmodel;

import java.util.SimpleTimeZone;

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
		setHitAble1();
		setHitAble2();
		setHitAble3();
		setHitAble4();
		setHitAble5();
		setHitAble6();
		setHitAble7();
		setHitAble8();
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
	
	public void setHitAble1(){
		for(int i = 2; i < sizeOfGameField - 2; i++){
			mainGamefield[i][0].setNoHit(1);
			mainGamefield[i][1].setNoHit(1);
		}
	}
	
	public void setHitAble2(){
		mainGamefield[sizeOfGameField - 2][0].setNoHit(2);
		mainGamefield[sizeOfGameField - 2][1].setNoHit(2);
		mainGamefield[sizeOfGameField - 1][1].setNoHit(2);
		mainGamefield[sizeOfGameField - 1][0].setNoHit(2);
	}
	
	public void setHitAble3(){
		for(int i = 2; i < sizeOfGameField - 2; i++){
			mainGamefield[sizeOfGameField - 1][i].setNoHit(3);
			mainGamefield[sizeOfGameField - 2][i].setNoHit(3);
		}
	}
	
	public void setHitAble4(){
		mainGamefield[sizeOfGameField - 1][sizeOfGameField - 2].setNoHit(4);
		mainGamefield[sizeOfGameField - 2][sizeOfGameField - 2].setNoHit(4);
		mainGamefield[sizeOfGameField - 2][sizeOfGameField - 1].setNoHit(4);
		mainGamefield[sizeOfGameField - 1][sizeOfGameField - 1].setNoHit(4);
	}
	
	public void setHitAble5(){
		for(int i = 2; i < sizeOfGameField - 2; i++){
			mainGamefield[i][sizeOfGameField - 1].setNoHit(5);
			mainGamefield[i][sizeOfGameField - 2].setNoHit(5);
		}
	}
	
	public void setHitAble6(){
		mainGamefield[1][sizeOfGameField - 1].setNoHit(6);
		mainGamefield[1][sizeOfGameField - 2].setNoHit(6);
		mainGamefield[0][sizeOfGameField - 2].setNoHit(6);
		mainGamefield[0][sizeOfGameField - 1].setNoHit(6);
	}
	
	public void setHitAble7(){
		for(int i = 2; i < sizeOfGameField - 2; i++){
			mainGamefield[0][i].setNoHit(7);
			mainGamefield[1][i].setNoHit(7);
		}
	}
	
	public void setHitAble8(){
		mainGamefield[0][1].setNoHit(8);
		mainGamefield[1][1].setNoHit(8);
		mainGamefield[1][0].setNoHit(8);
		mainGamefield[0][0].setNoHit(8);
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
