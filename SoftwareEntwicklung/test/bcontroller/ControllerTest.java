package bcontroller;

import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.Test;

public class ControllerTest {

	Controller c1;
	Controller c2;
	Controller c3;
	Controller c4;
	Controller c5;
	Controller c6; // test hit horizontal
	Controller c7; // test hit vertical
	Controller c8;
	
	@Before
	public void setUp(){
		c1 = new Controller(13);
		c2 = new Controller(11);
		c3 = new Controller(9);
		c4 = new Controller(2);
		c5 = new Controller(9);
		c6 = new Controller(9);
		c7 = new Controller(9);
		c8 = new Controller(9);
		
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
		
		c5.move(3, 0, 0, 0);
		c5.move(3, 0, 2, 1);
		c5.move(4, 2, 3, 2);
		c5.move(0, 3, 1, 2);
		c5.move(2, 4, 3, 4);
		c5.move(3, 0, 3, 0);
		c5.move(3, 4, 2, 4);
		c5.move(3, 0, 3, 7);
		c5.move(3, 8, 3, 2);
		c5.move(0, 3, 7, 3);
		c5.move(8, 3, 2, 3);
		
		c6.move(3, 0, 3, 2);
		c6.move(2, 4, 2, 2);
		c6.move(5, 0, 5, 2);
		c6.move(6, 4, 6, 2);
		
		c7.move(0, 3, 3, 3);
		c7.move(4, 2, 3, 2);
		c7.move(8, 5, 5, 5);
		c7.move(4, 6, 5, 6);
		
		c8.move(0, 3, 3, 3);
		c8.move(2, 4, 2, 3);
		c8.move(3, 0, 3, 1);
		c8.move(8, 3, 5, 3);
		c8.move(3, 8, 2, 8);
		c8.move(4, 2, 4, 3);
		
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
