package cmodel;

import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.Test;

public class FieldTest {

	Field f1;
	Field f2;
	Field f3;
	Field f4;
	Field f5;
	
	@Before
	public void setUp(){
		f1 = new Field();
		f2 = new Field();
		f3 = new Field();
		f4 = new Field();
		f5 = new Field();
		
		f3.setCharakter(new Stone(1));
		f4.setCharakter(new Stone(3));
		f5.setVictory(true);
	}
	
	@Test
	public void testGetOccupied(){
		assertEquals(0, f1.getOccupied());
	}
	
	@Test
	public void testSetQccupied(){
		f2.setOccupied(1);
		assertEquals(1, f2.getOccupied());
		f1.setOccupied(4);
		assertEquals(4, f1.getOccupied());
	}
	
	@Test
	public void testIsVictory(){
		assertFalse(f1.isVictory());
	}
	
	@Test
	public void testSetVictory(){
		f2.setVictory(true);
		assertTrue(f2.isVictory());
	}
	
	@Test
	public void testGetCharakter(){
		assertNotNull(f1.getCharakter());
	}
	
	@Test
	public void testSetCharakter(){
		f2.setCharakter(new Stone(2));
		assertNotNull(f2.getCharakter());
	}
	
	@Test
	public void testToString(){
		assertSame(" _ ", f1.toString());
		assertEquals(" D ", f2.toString());
		assertEquals(" A ", f3.toString());
		assertEquals(" K ", f4.toString());
		assertEquals(" X ", f5.toString());
	}

}
