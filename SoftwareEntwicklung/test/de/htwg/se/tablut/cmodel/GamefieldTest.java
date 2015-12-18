package de.htwg.se.tablut.cmodel;

import static org.junit.Assert.*;

import org.junit.Test;

import org.junit.Before;
public class GamefieldTest {

	Gamefield g1;
	Gamefield g2;
	Gamefield g3;
	Gamefield g4;
	
	@Before
	public void setUp(){
		g1 = new Gamefield();
		g2 = new Gamefield();
		g3 = new Gamefield();
		g4 = new Gamefield();
		
		g1.setStart(9);
		g2.setStart(11);
		g3.setStart(13);
		g4.setStart(4);
		
	}
	
	@Test
	public void testGetGameField() {
		assertNotNull(g1.getGameField());
		assertNull(g4.getGameField());
	}
	
	@Test
	public void testGetField(){
		assertNotNull(g1.getField(0, 0));
	}
	
	@Test
	public void testSetGameField(){
		g4.setGameField(g1.getGameField());
		assertSame(g1.getGameField(), g4.getGameField());
	}
	
	@Test
	public void testGetSizeOfGameField(){
		assertEquals(9, g1.getSizeOfGameField());
	}
	
	@Test
	public void testSetSizeOfGameField(){
		g4.setSizeOfField(9);
		assertEquals(9, g4.getSizeOfGameField());
	}
	
	@Test
	public void testSetStandard(){
		g1.setStandard();
		assertTrue(g1.getField(0, 0).isVictory());
	}
	
	@Test
	public void testSetStartfield(){
		g1.setStartfieldAttack();
		assertTrue(g1.getField(g1.getSizeOfGameField()/2, g1.getSizeOfGameField()/2).getCharakter().getIsKing());
	}
	
	@Test
	public void testPlaceAtk(){
		g2.placeAtk();
		assertEquals(1, g2.getField(g2.getSizeOfGameField()/2, 0).getCharakter().getUnitSpecification());
	}
}
