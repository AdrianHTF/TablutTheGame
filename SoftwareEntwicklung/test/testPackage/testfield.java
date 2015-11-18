package testPackage;
import cmodel.*;

public class testfield {
	static field f;

	public testfield(){
		f = new field();
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
		f.setCharakter(new stone(1));
		System.out.println(f);
		f.setCharakter(new stone(2));
		System.out.println(f);
		f.setCharakter(new stone(3));
		System.out.println(f);
		f.setCharakter(new stone(4));
		System.out.println(f);
		f.setOccupied(1);
		System.out.println(f);
		
		teststone z = new teststone();
		for (stone s : z.lallstone){
			System.out.println(s.getUnitSpecification());
			s.setUnitSpecification(1);
			System.out.println(s.getUnitSpecification());
		}
	
	}
}
