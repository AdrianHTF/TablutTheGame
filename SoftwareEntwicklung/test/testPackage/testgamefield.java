package testPackage;
import cmodel.*;

public class testgamefield {

	public testgamefield(){
		Gamefield gf = new Gamefield(3);
		Gamefield gf2 = new Gamefield(9);
		Gamefield gf3 = new Gamefield(12);
		Field[][] testF = new Field[3][3];
		
		gf.getField();
		gf2.getField(1, 1);
		System.err.println(gf2.getSizeOfGameField());
		gf.setSizeOfField(7);
		System.out.println(gf.getSizeOfGameField());
		gf.setField(testF);
		System.out.println(gf3);
	}
}
