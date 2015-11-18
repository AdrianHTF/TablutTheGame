package bcontroller;
import cmodel.*;

public class controller{
	
	private Gamefield gamefield;
	
	public controller(int sizeOfMatrix){
		gamefield = new Gamefield(sizeOfMatrix);
	}
	public void printField(){
		for (int i = 0; i < gamefield.getSizeOfGameField(); i++){
			for (int j = 0; j< gamefield.getSizeOfGameField(); j++){
				if((j % gamefield.getSizeOfGameField()) == 0)
					System.out.println("\n");
				System.out.print(gamefield.getField(j, i));
			}
		}
	}
	public void move(int xStart, int yStart, int xZiel, int yZiel){
		stone drawStone;
		stone changeStone;
		drawStone = gamefield.getField(xStart-1, yStart-1).getCharakter();
		changeStone = gamefield.getField(xZiel-1, yZiel-1).getCharakter();
		gamefield.getField(xStart-1, yStart-1).setCharakter(changeStone);
		gamefield.getField(xZiel-1, yZiel-1).setCharakter(drawStone);
	}
}