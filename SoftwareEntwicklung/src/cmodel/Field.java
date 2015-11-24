package cmodel;

public class Field {
	
	private int occupied = 0;
	private boolean victory = false;
	private Stone charakter = new Stone(0);

	public Field(){
		
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

	public Stone getCharakter() {
		return charakter;
	}

	public void setCharakter(Stone charakter) {
		this.charakter = charakter;
		if(charakter.getUnitSpecification() != 0)
			this.setOccupied(2);
	}
	
	@Override
	public String toString(){
		String d = "_";
		Stone k = getCharakter();
		
		if (k.getUnitSpecification() == 1){
			d = "A";
		}else if (k.getUnitSpecification() == 2){
			d = "D";
		}else if (k.getUnitSpecification() == 3){
			d = "K";
		}else if (isVictory()){
			d = "X";
		}
		StringBuilder s = new StringBuilder();
		s.append(" ").append(d).append(" ");
		
		return s.toString();
	}
}
