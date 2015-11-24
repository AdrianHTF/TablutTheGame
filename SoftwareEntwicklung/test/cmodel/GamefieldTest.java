package cmodel;

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
		g1 = new Gamefield(9);
		g2 = new Gamefield(11);
		g3 = new Gamefield(13);
		g4 = new Gamefield(4);
		
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
		assertEquals(3, g1.getField(g1.getSizeOfGameField()/2, g1.getSizeOfGameField()/2).getCharakter().getUnitSpecification());
	}
	
	@Test
	public void testPlaceAtk(){
		g2.placeAtk();
		assertEquals(1, g2.getField(g2.getSizeOfGameField()/2, 0).getCharakter().getUnitSpecification());
	}
}
