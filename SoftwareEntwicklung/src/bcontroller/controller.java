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
		drawStone = gamefield.getField(xStart, yStart).getCharakter();
		changeStone = gamefield.getField(xZiel, yZiel).getCharakter();
		
		if((xStart == xZiel && yStart == yZiel) 
				|| (xStart != xZiel && yStart != yZiel)){ // Diagonales ziehen verboten
			System.out.println("\nDiagonales ziehen nicht möglich!\n");
		
		} else if ((gamefield.getField(xZiel, yZiel).getOccupied() == 1) 
				&& drawStone.getUnitSpecification() != 3){ // Feld nur für den König begehbar
			System.out.println("\nSiegfeld/Thron!\n");

		} else if ((changeStone.getUnitSpecification() != 0)){ // Zug nicht möglich, da Feld belegt
			System.out.println("\nFeld belget!\n");
		
		} else {
			if(drawStone.getAktive() == 1){
				gamefield.getField(xStart, yStart).setCharakter(changeStone);
				gamefield.getField(xZiel, yZiel).setCharakter(drawStone);
				
				for (int i = 0; i < gamefield.getSizeOfGameField(); i++){
					for (int j = 0; j< gamefield.getSizeOfGameField(); j++){
						if(gamefield.getField(i, j).getCharakter().getAktive() == 1){
							gamefield.getField(i, j).getCharakter().setAktive(2);
						} else if(gamefield.getField(i, j).getCharakter().getAktive() == 2){
							gamefield.getField(i, j).getCharakter().setAktive(1);
						}
					}
				}
			} else
			System.out.println("\nNicht am Zug!\n");
		}
	}
	public boolean winGame(){
		if((gamefield.getField(gamefield.getSizeOfGameField()-1, gamefield.getSizeOfGameField()-1).getCharakter().getUnitSpecification() == 3)
				|| (gamefield.getField(0, gamefield.getSizeOfGameField()-1).getCharakter().getUnitSpecification() == 3)
				|| (gamefield.getField(gamefield.getSizeOfGameField()-1, 0).getCharakter().getUnitSpecification() == 3)
				|| (gamefield.getField(0, 0).getCharakter().getUnitSpecification() == 3)){
			System.out.println("\nVerteidiger hat gewonnen!\n");
			return true;
		} else
		return false;
	}
}