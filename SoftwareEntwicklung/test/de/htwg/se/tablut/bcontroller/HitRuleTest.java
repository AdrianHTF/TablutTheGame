package de.htwg.se.tablut.bcontroller;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import de.htwg.se.tablut.bcontroller.impl.HitRule;

public class HitRuleTest {

	HitRule hr1;
	HitRule hr2;
	HitRule hr3;
	
	@Before
	public void setUp(){
		hr1 = new HitRule();
		hr2 = new HitRule();
		hr3 = new HitRule();
		
		hr1.getKingVictory();
		hr2.getKingVictory();
		hr3.getKingVictory();
		
		hr1.setKingVictory(false);
		hr2.setKingVictory(false);
		hr3.setKingVictory(true);
	}
	
	@Test
	public void testGetKingVictory(){
		assertTrue(hr3.getKingVictory());
		assertFalse(hr2.getKingVictory());
	}
	
}
