package de.htwg.se.tablut.aview;

import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.Test;

public class TextUITest {
	
	TextUI ui1;
	
	@Before
	public void setUp(){
		ui1 = new TextUI();
		ui1.setGameFieldSize(13);
	}
	
	@Test
	public void testSetGameFieldSize(){
		ui1.setGameFieldSize(9);
		assertEquals(9, ui1.getGameFieldSize());
	}

	@Test
	public void testGetGameFieldSize(){
		assertEquals(13, ui1.getGameFieldSize());
	}
	
	@Test
	public void testSetController(){
		ui1.setController();
	}
}
