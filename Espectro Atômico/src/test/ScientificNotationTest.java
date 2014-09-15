package test;

import static org.junit.Assert.*;

import java.util.Iterator;

import model.ScientificNotation;

import org.junit.Before;
import org.junit.Test;

public class ScientificNotationTest {
	
	ScientificNotation sn;
	ScientificNotation sn2;
	ScientificNotation sn3;

	@Before
	public void setUp() throws Exception {
		sn = new ScientificNotation(new Double(1.5));
		sn2 = new ScientificNotation(new Integer(0));
		sn3 = new ScientificNotation(new Double(-1.5));
	}
	
	@Test
	public void testScientificNotation() {
		
		assertEquals(-2, sn.getExponent());
		assertEquals(0, sn2.getExponent());
		assertEquals(-2, sn3.getExponent());
		
		assertEquals(150.0, sn.getMantissa(), 0);
		assertEquals(0.0, sn2.getMantissa(), 0);
		assertEquals(-150.0, sn3.getMantissa(), 0);
		
		assertEquals("150E-2", sn.toString());
		assertEquals("0", sn2.toString());
		assertEquals("-150E-2", sn3.toString());
		
	}
	
	@Test
	public void testSetup() {
		Integer[] elements = {5, 4, 8, 6, 7};
		for (int element: elements) {
			sn = new ScientificNotation(element);
			
			assertEquals(-2, sn.getExponent());
			assertEquals(element*100.0, sn.getMantissa(), 0);
			assertEquals(""+ element +"00E-2", sn.toString());
	
		}
		
		Integer[] elements2 = {50, 40, 80, 60, 70};
		for (int element: elements2) {
			sn2 = new ScientificNotation(element);
			
			assertEquals(-1, sn2.getExponent());
			assertEquals(element*10.0, sn2.getMantissa(), 0);
			assertEquals(""+ element +"0E-1", sn2.toString());
			
		}
		
		Double[] elements3 = {5.0, 4.0, 8.0, 6.0, 7.0};
		for (double element: elements3) {
			sn3 = new ScientificNotation(element);
			
			assertEquals(-2, sn3.getExponent());
			assertEquals(element*100.0, sn3.getMantissa(), 0);
			assertEquals(""+ ((int) element) +"00E-2", sn3.toString());
			
		}
	}

}
