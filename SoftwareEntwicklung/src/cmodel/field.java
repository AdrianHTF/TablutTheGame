package cmodel;

public class field {
	
	private int occupied = 0;
	private boolean victory = false;
	private stone charakter = new stone(0);

	public field(){
		
	}

	public int getOccupied() {
		return occupied;
	}

	public void setOccupied(int occupied) {
		this.occupied = occupied;
	}

	public boolean isVictory() {
		return victory;
	}

	public void setVictory(boolean victory) {
		this.victory = victory;
	}

	public stone getCharakter() {
	
		return charakter;
	}

	public void setCharakter(stone charakter) {
		this.charakter = charakter;
	}
	
	@Override
	public String toString(){
		String d = "_";
		stone k = getCharakter();
		
		if (k.getUnitSpecification() == 1){
			d = "A";
		}else if (k.getUnitSpecification() == 2){
			d = "D";
		}else if (k.getUnitSpecification() == 3){
			d = "K";
		}else if (getOccupied() == 1){
			d = "X";
		}
		StringBuilder s = new StringBuilder();
		s.append("|").append(d).append("|");
		
		return s.toString();
	}
}
