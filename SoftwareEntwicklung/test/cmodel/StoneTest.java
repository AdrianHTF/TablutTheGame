package cmodel;

import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.Test;

import java.util.BitSet;


public class StoneTest {

	Stone s0;
	Stone s1;
	Stone s2;
	Stone s3;
	Stone s4;
	
	@Before
	public void setUp(){
		s0 = new Stone(0);
		s1 = new Stone(1);
		s2 = new Stone(2);
		s3 = new Stone(3);
		s4 = new Stone(4);
	}
	
	@Test
	public void testGetUnitSpecification(){
		assertEquals(0, s0.getUnitSpecification());
		assertEquals(1, s1.getUnitSpecification());
		assertEquals(2, s2.getUnitSpecification());
		assertEquals(3, s3.getUnitSpecification());
		assertEquals(0, s4.getUnitSpecification());
	}
	
	@Test
	public void testSetUnitSpecification(){
		s0.setUnitSpecification(3);
		assertEquals(3, s0.getUnitSpecification());
	}

}
