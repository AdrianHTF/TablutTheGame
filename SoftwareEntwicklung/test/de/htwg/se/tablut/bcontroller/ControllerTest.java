package de.htwg.se.tablut.bcontroller;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import de.htwg.se.tablut.bcontroller.impl.Controller;

public class ControllerTest {

	Controller c1; // test size 13 and not wingame by hiting king
	Controller c2; // test legal move and not wingame by secure king and size 11
	Controller c3; // test wingame by secure king right top
	Controller c4; // test illegal size
	Controller c5; // test illegal move
	Controller c6; // test hit horizontal
	Controller c7; // test hit vertical
	Controller c8; // expected no exception by hinting near wall
	Controller c9; // same like c8
	Controller c10; // same like c8 and test normal attackwingame
	Controller c11; // test wingame by secure king left top 
	Controller c12; // test wingame by secure king right bott
	Controller c13; // test wingame by secure king left bott
	Controller c14; // test no hit bott cause king and hit king
	Controller c15; // test hit king in middle
	Controller c16; // test right side kinghit
	Controller c17; // test upper side kinghit
	Controller c18; // test left side kinghit
	Controller c19;
	
	@Before
	public void setUp(){
		c1 = new Controller(13); c2 = new Controller(11); c3 = new Controller(9);
		c4 = new Controller(2); c5 = new Controller(9); c6 = new Controller(9);
		c7 = new Controller(9); c8 = new Controller(9); c9 = new Controller(9);	
		c10 = new Controller(9); c11 = new Controller(9); c12 = new Controller(9);
		c13 = new Controller(9); c14 = new Controller(9); c15 = new Controller(9);
		c16 = new Controller(9); c17 = new Controller(9); c18 = new Controller(9);
		c19 = new Controller();
		
		c3.move(3, 0, 3, 1); c3.move(4, 3, 2, 3); c3.move(3, 1, 3, 0); c3.move(4, 4, 4, 3);
		c3.move(3, 0, 3, 1); c3.move(4, 3, 7, 3); c3.move(3, 1, 3, 0); c3.move(7, 3, 7, 0);
		c3.move(3, 0, 3, 1);
		c3.move(7, 0, 8, 0);
		
		c5.move(3, 0, 0, 0); c5.move(3, 0, 2, 1); c5.move(4, 2, 3, 2); c5.move(0, 3, 1, 2);
		c5.move(2, 4, 3, 4); c5.move(3, 0, 3, 0); c5.move(3, 4, 2, 4); c5.move(3, 0, 3, 7);
		c5.move(3, 8, 3, 2); c5.move(0, 3, 7, 3); c5.move(8, 3, 2, 3);
		
		c6.move(3, 0, 3, 2); c6.move(2, 4, 2, 2); c6.move(5, 0, 5, 2); c6.move(6, 4, 6, 2);
		
		c7.move(0, 3, 3, 3); c7.move(4, 2, 3, 2); c7.move(8, 5, 5, 5); c7.move(4, 6, 5, 6);
		
		c8.move(0, 3, 3, 3); c8.move(2, 4, 2, 3); c8.move(3, 0, 3, 1); c8.move(8, 3, 5, 3);
		c8.move(3, 8, 2, 8); c8.move(4, 2, 4, 3);
		
		c9.move(4, 7, 5, 7); c9.move(4, 6, 8, 6); c9.move(5, 7, 8, 7);
		c9.move(2, 4, 2, 8); c9.move(1, 4, 1, 8);
		
		c10.move(5, 0, 6, 0); c10.move(2, 4, 2, 0); c10.move(1, 4, 1, 0); c10.move(4, 2, 0, 2);
		c10.move(4, 1, 0, 1); c10.move(6, 4, 6, 8); c10.move(7, 4, 7, 8); c10.move(4, 3, 7, 3);
		c10.move(4, 4, 4, 1); c10.move(6, 0, 6, 1); c10.move(4, 4, 4, 1); c10.move(3, 4, 3, 7);
		c10.move(6, 1, 5, 1); c10.move(7, 3, 7, 6);	c10.move(0, 1, 3, 1); c10.move(3, 4, 3, 5);
		c10.move(8, 3, 4, 3); c10.move(4, 6, 5, 6);	c10.move(4, 3, 4, 2);
		
		c11.move(3, 0, 3, 1); c11.move(4, 3, 5, 3); c11.move(3, 1, 3, 0); c11.move(4, 4, 4, 3);
		c11.move(3, 0, 3, 1); c11.move(4, 3, 1, 3); c11.move(3, 1, 3, 0); c11.move(1, 3, 1, 0);
		c11.move(3, 0, 3, 1); c11.move(1, 0, 0, 0);
		
		c12.move(3, 0, 3, 1); c12.move(4, 5, 3, 5); c12.move(3, 1, 3, 0); c12.move(4, 4, 4, 5);
		c12.move(3, 0, 3, 1); c12.move(4, 5, 7, 5); c12.move(3, 1, 3, 0); c12.move(7, 5, 7, 8);
		c12.move(3, 0, 3, 1); c12.move(7, 8, 8, 8);
		
		c13.move(3, 0, 3, 1); c13.move(4, 5, 5, 5); c13.move(3, 1, 3, 0); c13.move(4, 4, 4, 5);
		c13.move(3, 0, 3, 1); c13.move(4, 5, 1, 5); c13.move(3, 1, 3, 0); c13.move(1, 5, 1, 8);
		c13.move(3, 0, 3, 1); c13.move(1, 8, 0, 8);
		
		c14.move(3, 8, 1, 8); c14.move(4, 5, 7, 5); c14.move(0, 5, 0, 7); c14.move(4, 4, 4, 5);
		c14.move(8, 3, 5, 3); c14.move(4, 5, 1, 5); c14.move(0, 3, 3, 3); c14.move(1, 5, 1, 7);
		c14.move(4, 7, 2, 7); c14.move(4, 6, 8, 6); c14.move(2, 7, 4, 7); c14.move(1, 7, 2, 7);
		c14.move(4, 7, 3, 7); c14.move(2, 7, 2, 8); c14.move(4, 8, 3, 8); c14.move(2, 4, 2, 5);
		c14.move(3, 7, 2, 7);
		
		c15.move(3, 0, 3, 1); c15.move(4, 3, 1, 3); c15.move(5, 0, 5, 3); c15.move(4, 4, 4, 3);
		c15.move(3, 8, 1, 8); c15.move(4, 2, 1, 2); c15.move(3, 1, 3, 3); c15.move(1, 2, 1, 1);
		c15.move(4, 1, 4, 2);
		
		c16.move(5, 0, 7, 0); c16.move(5, 4, 5, 0); c16.move(4, 1, 7, 1); c16.move(4, 4, 5, 4);
		c16.move(3, 0, 3, 1); c16.move(5, 4, 5, 2); c16.move(3, 1, 5, 1); c16.move(5, 2, 8, 2);
		c16.move(7, 1, 8, 1); c16.move(3, 4, 3, 0); c16.move(7, 0, 7, 2);
		
		c17.move(1, 4, 1, 3); c17.move(4, 3, 7, 3); c17.move(7, 4, 7, 5); c17.move(4, 4, 4, 3);
		c17.move(0, 5, 1, 5); c17.move(4, 3, 2, 3); c17.move(1, 3, 1, 1); c17.move(2, 3, 2, 0);
		c17.move(1, 1, 2, 1); c17.move(5, 4, 5, 1); c17.move(1, 5, 1, 0);
		
		c18.move(1, 4, 1, 1); c18.move(4, 3, 7, 3); c18.move(7, 4, 7, 5); c18.move(4, 4, 4, 3);
		c18.move(4, 1, 3, 1); c18.move(4, 3, 1, 3); c18.move(3, 1, 3, 2); c18.move(1, 3, 1, 2);
		c18.move(8, 3, 8, 2); c18.move(1, 2, 0, 2); c18.move(1, 1, 0, 1); c18.move(7, 3, 7, 2);
		c18.move(3, 2, 1, 2); 
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
		assertFalse(c11.winGame());
		assertFalse(c12.winGame());
		assertFalse(c13.winGame());
		assertTrue(c2.winGame());
	}
	
	@Test
	public void testWinGameAttack(){
		assertFalse(c18.winGameAttack());
		assertFalse(c17.winGameAttack());
		assertFalse(c16.winGameAttack());
		assertFalse(c15.winGameAttack());
		assertFalse(c14.winGameAttack());
		assertFalse(c10.winGameAttack());
		assertTrue(c1.winGameAttack());
	}
	
	@Test
	public void testgetWinGameAttack(){
		assertFalse(c10.getWinGameAttack());
	}
	
	@Test
	public void testSetWinGameAttack(){
		c1.setWinGameAttack(true);
		assertTrue(c1.getWinGameAttack());
	}
	
	@Test
	public void testGetGamefield(){
		c1.getGamefield();
	}
	
	@Test
	public void testSetMatrixSize(){
		c1.setMatrixSize(13);
		c10.setMatrixSize(9);
		assertEquals(c1.getMatrixSize(), 13);
		assertEquals(c10.getMatrixSize(), 9);
	}
	
	@Test
	public void testGetPlayerTurn(){
		c1.getPlayerTurn();
	}
	

	
}
