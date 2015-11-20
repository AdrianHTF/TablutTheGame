package testPackage;
import cmodel.*;

public class testfield {
	static Field f;

	public testfield(){
		f = new Field();
	}
	public static void main(String[] args){
		testgamefield testgamefield = new testgamefield();
		testfield x = new testfield();
		System.out.println(f);
		f.setOccupied(0);
		f.setVictory(true);
		System.out.println(f.isVictory());
		f.setVictory(false);
		System.out.println(f.isVictory());
		f.setCharakter(new Stone(1));
		System.out.println(f);
		f.setCharakter(new Stone(2));
		System.out.println(f);
		f.setCharakter(new Stone(3));
		System.out.println(f);
		f.setCharakter(new Stone(4));
		System.out.println(f);
		f.setOccupied(1);
		System.out.println(f);
		
		teststone z = new teststone();
		for (Stone s : z.lallstone){
			System.out.println(s.getUnitSpecification());
			s.setUnitSpecification(1);
			System.out.println(s.getUnitSpecification());
		}
	
	}
}
