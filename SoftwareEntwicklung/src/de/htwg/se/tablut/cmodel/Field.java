package de.htwg.se.tablut.cmodel;

public class Field implements IField {
	
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

	@Override
	public int getOccupied() {
		return occupied;
	}

	@Override
	public void setOccupied(int occupied) {
		this.occupied = occupied;
	}

	@Override
	public boolean isVictory() {
		return victory;
	}

	@Override
	public void setVictory(boolean victory) {
		this.victory = victory;
	}
	
	@Override
	public int getNoHit(){
		return noHit;
	}
	
	@Override
	public void setNoHit(int noHit){
		this.noHit = noHit;
	}

	@Override
	public Stone getCharakter() {
		return charakter;
	}

	@Override
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
