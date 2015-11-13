package bcontroller;
import cmodel.*;

public class controller{
	
	private Gamefield gamfield;
	
	public controller(int sizeOfMatrix){
		gamfield = new Gamefield(sizeOfMatrix);
	}
	public void printField(){
		for (int i = 0; i < gamfield.getSizeOfGameField(); i++){
			for (int j = 0; j< gamfield.getSizeOfGameField(); j++){
				if((j % gamfield.getSizeOfGameField()) == 0)
					System.out.println("\n");
				System.out.print(gamfield.getField(j, i));
			}
		}
	}
}