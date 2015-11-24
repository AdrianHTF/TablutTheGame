package bcontroller;

import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.Test;

public class ControllerTest {

	Controller c1;
	Controller c2;
	Controller c3;
	Controller c4;
	
	@Before
	public void setUp(){
		c1 = new Controller(13);
		c2 = new Controller(11);
		c3 = new Controller(9);
		c4 = new Controller(2);
		
		c3.move(3, 0, 3, 1);
		c3.move(4, 3, 2, 3);
		c3.move(3, 1, 3, 0);
		c3.move(4, 4, 4, 3);
		c3.move(3, 0, 3, 1);
		c3.move(4, 3, 7, 3);
		c3.move(3, 1, 3, 0);
		c3.move(7, 3, 7, 0);
		c3.move(3, 0, 3, 1);
		c3.move(7, 0, 8, 0);
	}
	
	@Test
	public void testPrintField(){
		c1.printField();
	}
	
	@Test
	public void testMove(){
		c2.move(3, 0, 3, 1);
		c2.move(4, 2, 3, 2);
		c2.move(4, 2, 3, 2);
		c2.move(3, 1, 0, 0);
	}
	
	@Test
	public void testWinGame(){
		assertFalse(c3.winGame());
		assertTrue(c2.winGame());
	}
}
