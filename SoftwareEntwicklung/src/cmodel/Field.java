package cmodel;

public class Field {
	
	private int occupied = 0;
	private boolean victory = false;
	private Stone charakter = new Stone(0);
	
	// 0 = every where hit able
	// 1 = no top hit
	// 2 = no top right hit
	// 3 = no right hit
	// 4 = no right bott hit
	// 5 = no bott hit
	// 6 = no bott left hit
	// 7 = no left hit
	// 8 = no left top hit
	private int noHit = 0;

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
	
	public int getNoHit(){
		return noHit;
	}
	
	public void setNoHit(int noHit){
		this.noHit = noHit;
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
		}else if (k.getIsKing()){
			d = "K";
		}else if (k.getUnitSpecification() == 2){
			d = "D";
		}else if (isVictory()){
			d = "X";
		}
		StringBuilder s = new StringBuilder();
		s.append(" ").append(d).append(" ");
		
		return s.toString();
	}
}
