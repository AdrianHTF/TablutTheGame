package bcontroller;
import cmodel.*;

public class Rules {
	
	public boolean drawRules(Gamefield gamefield,
			Stone drawStone, Stone changeStone,
			int xStart, int xZiel, int yStart, int yZiel){
		
		if((xStart == xZiel && yStart == yZiel) 
			|| (xStart != xZiel && yStart != yZiel) 
			|| (gamefield.getField(xZiel, yZiel).getOccupied() == 1) 
			&& (drawStone.getUnitSpecification() != 3) 
			|| (changeStone.getUnitSpecification() != 0)){
				return false;
			} else {
				if(xStart == xZiel && !yMove(gamefield, xStart, yStart, yZiel)){
					return false;
				} else if(yStart == yZiel && !xMove(gamefield, xStart, xZiel, yStart)){
					return false;
				}
				return true;
			}
	}
	
	public boolean yourTurn(boolean playerTurn, Gamefield gamefield,
			int xStart, int yStart){
		if (playerTurn){
			if(gamefield.getField(xStart, yStart).getCharakter().getUnitSpecification() == 1){
				return true;
			}
		}else{
			if(gamefield.getField(xStart, yStart).getCharakter().getUnitSpecification() > 1){
				return true;
			}
		}
		return false;
	}
	
	public boolean hitHorizontalRight(Gamefield gamefield, int xAxis, int yAxis){
		if((gamefield.getField(xAxis + 1 , yAxis).getCharakter().getUnitSpecification() != 0)
			&& ((gamefield.getField(xAxis, yAxis).getCharakter().getUnitSpecification() != gamefield.getField(xAxis + 1, yAxis).getCharakter().getUnitSpecification())
			&& (gamefield.getField(xAxis + 2 , yAxis).getCharakter().getUnitSpecification() == gamefield.getField(xAxis, yAxis).getCharakter().getUnitSpecification()))){
			return true;
		}
		return false;
	}
	
	public boolean hitHorizontalLeft(Gamefield gamefield, int xAxis, int yAxis){
		if(gamefield.getField(xAxis - 1, yAxis).getCharakter().getUnitSpecification() != 0 
				&& ((gamefield.getField(xAxis, yAxis).getCharakter().getUnitSpecification() != gamefield.getField(xAxis - 1, yAxis).getCharakter().getUnitSpecification())
				&& (gamefield.getField(xAxis - 2 , yAxis).getCharakter().getUnitSpecification() == gamefield.getField(xAxis, yAxis).getCharakter().getUnitSpecification()))){
			return true;
		}
		return false;
	}
	
	public boolean hitVerticalUpper(Gamefield gamefield, int xAxis, int yAxis){
		if(gamefield.getField(xAxis, yAxis - 1).getCharakter().getUnitSpecification() != 0 
				&& ((gamefield.getField(xAxis, yAxis).getCharakter().getUnitSpecification() != gamefield.getField(xAxis, yAxis - 1).getCharakter().getUnitSpecification())
				&& (gamefield.getField(xAxis , yAxis - 2).getCharakter().getUnitSpecification() == gamefield.getField(xAxis, yAxis).getCharakter().getUnitSpecification()))){
			return true;
		}
		return false;
	}
	
	public boolean hitVerticalLower(Gamefield gamefield, int xAxis, int yAxis){
		if((gamefield.getField(xAxis, yAxis + 1).getCharakter().getUnitSpecification() != 0)
				&& ((gamefield.getField(xAxis, yAxis).getCharakter().getUnitSpecification() != gamefield.getField(xAxis, yAxis + 1).getCharakter().getUnitSpecification())
				&& (gamefield.getField(xAxis , yAxis + 2).getCharakter().getUnitSpecification() == gamefield.getField(xAxis, yAxis).getCharakter().getUnitSpecification()))){
				return true;
			}
		return false;
	}
	
	public boolean hitKing(){
		return false;
	}
	
	public boolean yMove(Gamefield gamefield,
			int xStart, int yStart, int yZiel){
		if(yStart < yZiel){
			for(int i = yStart+1; i <= yZiel; i++){
				if (gamefield.getField(xStart, i).getCharakter().getUnitSpecification() > 0){
					return false;
				}
			}
		} else{
			for(int j = yStart-1; j >= yZiel; j--){
				if (gamefield.getField(xStart, j).getCharakter().getUnitSpecification() > 0){
					return false;
				}
			}
		}
		return true;
	}
	
	public boolean xMove(Gamefield gamefield,
			int xStart, int xZiel,  int yStart){
		if(xStart < xZiel){
			for (int i = xStart+1; i <= xZiel; i++){
				if (gamefield.getField(i, yStart).getCharakter().getUnitSpecification() > 0){
					return false;
				}
			}
		}else{
			for(int j = xStart-1; j >= xZiel; j--){
				if (gamefield.getField(j, yStart).getCharakter().getUnitSpecification() > 0){
					return false;
				}
			}
		}
		return true;
	}
}
